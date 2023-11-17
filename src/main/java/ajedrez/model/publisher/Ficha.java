package ajedrez.model.publisher;

import java.util.HashMap;
import java.util.ArrayList;

import ajedrez.model.JUGADOR;
import ajedrez.model.FICHA;
import ajedrez.model.Tablero;
import ajedrez.model.sucriber.Suscriber;

public abstract class Ficha implements Publisher{
    private FICHA ficha;
    private String id;
    private JUGADOR jugador;
    private Suscriber suscriber;
    private Ficha captura = null;
    private HashMap<Integer, ArrayList<Integer>>  movimientosPosibles;
    private final int FILA_FINAL;

    public Ficha(FICHA ficha, String id, JUGADOR jugador) {
        this.ficha = ficha;
        this.id = id;
        this.jugador = jugador;
        this.FILA_FINAL = (this.jugador == JUGADOR.UNO)? 7 : 0;
    }

    public HashMap<Integer, ArrayList<Integer>> getMovimientos() {
        return this.movimientosPosibles;
    }

    public void setMovimientos(HashMap<Integer, ArrayList<Integer>> movimientos) {
        this.movimientosPosibles = movimientos;
    }

    public int getUltimaFila() {
        return this.FILA_FINAL;
    }

    public String getNombre(){
        return this.ficha.toString().toLowerCase();
    }
    
    public String getId() {
        return this.id;
    }
        
    public Suscriber getSuscriber() {
        return this.suscriber;
    }

    public JUGADOR getJugador() {
        return this.jugador;
    }

    public void addsuscriber(Suscriber suscriber) {
        this.suscriber = suscriber;
    }

    public void notificar() {
        this.suscriber.update(this.captura);
    }

    public void setCaptura(Ficha fichaCapturada) {
        this.captura = fichaCapturada;
    }

/* Metodo utilizado para saber si se puede mover la ficha a la fila y columna indicadas por parametro
 * sobre el tablero tambien indicado por parametro. 
 * Devuelve True en caso de que si se pueda mover, en caso contrario, devuelve False
*/
    public Boolean mover(int fila, int columna, Tablero tablero) {
        if (!tablero.estaLaFicha(this)) return false;
        setCaptura(null);
        var movimientos = verificarMovimientosPosibles(tablero);
        if(movimientos.containsKey(fila) && movimientos.get(fila).contains(columna)) {
            verificarFichaSacada(tablero, fila, columna);
            return true;
        }
        return false;
    }

    protected void verificarFichaSacada(Tablero tablero, int fila, int columna) {
        tablero.sacarFicha(this);
        var posibleFichaCapturada = tablero.colocarFicha(this, fila, columna);
        if (posibleFichaCapturada != null) {
            setCaptura(posibleFichaCapturada);
            notificar();
        }
    }

/*  Metodo utilizado para saber que movimientos puedo realizar la ficha, sobre el tablero
*   que se le pasa por parametro.
*   Regresa un Hash con todos las posiciones a las que se puede mover la ficha donde:
*   Las keys son: Integers representando las filas y
*   Los values son: Un ArrayList que contiene las columnas de dicha fila.
 */
    public abstract HashMap<Integer, ArrayList<Integer>> verificarMovimientosPosibles(Tablero tablero);

}
