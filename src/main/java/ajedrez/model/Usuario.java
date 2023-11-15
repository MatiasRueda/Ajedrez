package ajedrez.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import ajedrez.App.NumJugador;
import ajedrez.model.publisher.Ficha;
import ajedrez.model.sucriber.RegistroFichas;

public class Usuario {
    private RegistroFichas registro = new RegistroFichas();
    private FabricaDeFichas fabrica = new FabricaDeFichas();
    private NumJugador numJugador;
    private Tablero tablero;
    private final int[] COLUMNA_PEON = {0, 1 , 2, 3, 4, 5, 6, 7};
    private final int[] COLUMNA_REINA = {3};
    private final int[] COLUMNA_REY = {4};
    private final int[] COLUMNA_TORRE = {0, 7};
    private final int[] COLUMNA_AFIL = {2, 5};
    private final int[] COLUMNA_CABALLO = {1, 6};
    private final int[][] POSICION_FICHAS = {COLUMNA_PEON, COLUMNA_TORRE, COLUMNA_CABALLO, COLUMNA_AFIL, COLUMNA_REINA, COLUMNA_REY};
    private final String[] NOMBRE_DE_FICHAS = {"Peon", "Torre", "Caballo", "Afil", "Reina", "Rey"};
    private HashMap<String, Ficha> fichasDisponibles = new HashMap<>();

    public Usuario(NumJugador numJugador, Tablero tablero) {
        this.numJugador = numJugador;
        this.tablero = tablero;
        agregarFichas();
    }
    
/* Metodo que se encarga de mover la ficha a la posicion pasada por parametros
*  en caso de que se pueda devuelve True, en caso contrario devuelve False
*/
    public Boolean moverFicha(int fila, int columna, Ficha ficha) {
        return ficha.mover(fila, columna, this.tablero);
    }

    public boolean gano() {
        return this.registro.reyCapturado();
    }

    public NumJugador getNumJugador() {
        return this.numJugador;
    }

    public int cantidadCapturas() {
        return this.registro.numeroDeCapturas();
    }

    public Ficha getUltimaCaptura() {
        return this.registro.getUltimaCaptura();
    }

// Metodo encargado de sacar la ficha de las disponibles que tiene el usuario
    public void sacarFicha(Ficha ficha) { 
        if (ficha == null) return;
        if (!this.fichasDisponibles.containsKey(ficha.getId())) return;
        this.fichasDisponibles.remove(ficha.getId());
    }


/* Metodo que se encarga de verificar de que el usuario rival siga teniendo movimientos disponibles
*  En caso de que siga teniendo movimientos disponibles devuelve False, en caso contrario devuelve True
*/
    public Boolean noHayMovimientosPosibles(Usuario rival, ControladorJaque control) {
        int noHayMovimientos = 0;
        for (Ficha ficha : this.fichasDisponibles.values()) {
            var movimientos = ficha.verificarMovimientosPosibles(this.tablero);
            if (ficha.getNombre().equals("Rey")) {
                control.setMovimientosPosibles(movimientos);
                movimientos = control.posibleJaque(rival, ficha);
            }
            if (movimientos.isEmpty()) noHayMovimientos++; 
        }
        return (noHayMovimientos == this.fichasDisponibles.size());
    }

/* Metodo que se encarga de verificar si existe jaque
*  en caso de que exista devuelve True, en caso contrario False 
*/
    public Boolean buscandoJaque() {
        for (Ficha ficha : this.fichasDisponibles.values()) {
            var movimientos = ficha.verificarMovimientosPosibles(this.tablero);
            if (movimientos.isEmpty()) continue;
            if (recorrerMovimientos(movimientos)) return true;
        }
        return false;
    }

    private Boolean recorrerMovimientos(HashMap<Integer, ArrayList<Integer>> movimientos) {
        for (int fila : movimientos.keySet()) {
            var columnas = movimientos.get(fila);
            if (jaque(fila, columnas)) return true;
        }
        return false;
    }

    private Boolean jaque(int fila, ArrayList<Integer> columnas) {
        for (int columna : columnas) {
            Ficha ficha  = this.tablero.getFicha(fila, columna);
            if (ficha == null) continue;
            if (ficha.getNombre().equals("Rey")) return true;
          }
        return false;
    }


//  Metodo utilizado para agregar todas las fichas al usuario
    private void agregarFichas() {
        for(int indice = 0; indice < NOMBRE_DE_FICHAS.length; indice++) {
            String nombreFicha = NOMBRE_DE_FICHAS[indice];
            agregarPorCantidadDeFichas(nombreFicha, indice);
        }
    }

    private void agregarPorCantidadDeFichas(String nombreFicha, int indice) {
        for (int indicePosicion = 0; indicePosicion < POSICION_FICHAS[indice].length; indicePosicion++){
            Ficha ficha = this.fabrica.getFicha(nombreFicha, UUID.randomUUID().toString(), this.numJugador);
            ficha.addsuscriber(registro);
            int filaElegida = (this.numJugador == NumJugador.UNO)? 0 : 7;
            if (nombreFicha.equals("Peon")) {
                filaElegida = (this.numJugador == NumJugador.UNO)? 1: 6;
            }
            this.tablero.colocarFicha(ficha, filaElegida, POSICION_FICHAS[indice][indicePosicion]);
            this.fichasDisponibles.put(ficha.getId(), ficha);
        }
    }

    public void agregarFichaAlasDisponibles(Ficha ficha) {
        this.fichasDisponibles.put(ficha.getId(), ficha);
    }

}