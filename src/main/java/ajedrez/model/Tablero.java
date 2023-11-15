package ajedrez.model;
import java.util.ArrayList;
import java.util.HashMap;

import ajedrez.model.publisher.Casilla;
import ajedrez.model.publisher.Ficha;

public class Tablero {
    private final int CANT_FILAS = 8;
    private final int CANT_COLUMNAS = 8;
    private ArrayList<ArrayList<Casilla>> casillas;
    private HashMap<String, ArrayList<Integer>> ubicacionFichas = new HashMap<String, ArrayList<Integer>>();


    public void llenarTablero() {
        this.casillas = new ArrayList<>(); 
        for (int i = 0; i < CANT_FILAS; i++) {
            this.casillas.add(new ArrayList<>());
            var filaElegida = this.casillas.get(i);

            for (int j = 0; j < CANT_COLUMNAS; j++) {
                filaElegida.add(new Casilla());
            }
        }
    }

    public Casilla getCasilla(int fila, int columna) {
        if (posicionFueraDelTablero(fila, columna)) return null;
        var filaElegida = this.casillas.get(fila);
        return filaElegida.get(columna);
    }

    public Ficha getFicha(int fila, int columna) {  
        var casillaElegida = getCasilla(fila, columna);
        if (casillaElegida == null) return null;
        return casillaElegida.getFicha();
    }

    public boolean sacarFicha(Ficha ficha) {
        if (!this.ubicacionFichas.containsKey(ficha.getId())) return false;
        var ubicacion = this.ubicacionFichas.get(ficha.getId());
        var filaActual = ubicacion.get(0);
        var colActual = ubicacion.get(1);
        var casillaElegida = getCasilla(filaActual, colActual);
        this.ubicacionFichas.remove(casillaElegida.getFicha().getId());
        casillaElegida.setFicha(null);
        return true;
    }

    public ArrayList<Integer> ubicacionActualFicha(Ficha ficha) {
        if (!estaLaFicha(ficha)) return null;
        return this.ubicacionFichas.get(ficha.getId());
    }

    public boolean estaLaFicha(Ficha ficha) {
        return (this.ubicacionFichas.containsKey(ficha.getId()))? true : false;
    }

    private void agregarUbicacionFicha(Ficha ficha, int fila, int columna) {
        if (!estaLaFicha(ficha)) {
            ubicacionFichas.put(ficha.getId(), new ArrayList<>());
        }
        ubicacionFichas.get(ficha.getId()).add(fila);
        ubicacionFichas.get(ficha.getId()).add(columna);
    }

    public Ficha colocarFicha(Ficha ficha, int fila, int columna) {
        if (posicionFueraDelTablero(fila, columna)) return null;
        Ficha fichaCapturada = null;
        var filaElegida = this.casillas.get(fila);
        var casillaActual = filaElegida.get(columna);
        if (casillaActual.getFicha() != null) {
            fichaCapturada = casillaActual.getFicha();
            sacarFicha(fichaCapturada);
        }
        casillaActual.setFicha(ficha);
        agregarUbicacionFicha(ficha, fila, columna);
        return fichaCapturada;
    }

    public boolean posicionOcupada(int fila, int columna) {
        return getCasilla(fila, columna).estaVacia() ? false : true;
    }

    public boolean posicionFueraDelTablero(int fila, int columna) {
        if (fila >= CANT_FILAS || columna >= CANT_COLUMNAS) return true;
        if (fila < 0 || columna < 0) return true;
        return false;
    }

    private void iterarCasilleros(ArrayList<Casilla> casilleros, ArrayList<ArrayList<String>> nombresFichas) {
        for (int columnaIndice = 0; columnaIndice < CANT_COLUMNAS; columnaIndice++) {
            var nombreYJugador = new ArrayList<String>();
            var casilleroActual = casilleros.get(columnaIndice);
            if (casilleroActual.estaVacia()) {
                nombreYJugador.add(""); 
                nombreYJugador.add(""); 
                nombresFichas.add(nombreYJugador);   
                continue;}
            nombreYJugador.add(casilleroActual.getFicha().getNombre());
            nombreYJugador.add(casilleroActual.getFicha().getNumJugador().toString());    
            nombresFichas.add(nombreYJugador);    
        }
    }

    public ArrayList<ArrayList<String>> getNombresFichasTablero() {
        ArrayList<ArrayList<String>> nombresFichas = new ArrayList<>();
        for (int filaIndice = 0; filaIndice < CANT_FILAS; filaIndice++) {
            var filaActual = this.casillas.get(filaIndice);
            iterarCasilleros(filaActual, nombresFichas);
        }
        return nombresFichas;
    }

}
