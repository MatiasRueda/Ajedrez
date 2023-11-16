package ajedrez.model.tipoficha;

import java.util.HashMap;
import java.util.ArrayList;

import ajedrez.App.NumJugador;
import ajedrez.model.Tablero;
import ajedrez.model.publisher.Ficha;
import ajedrez.model.tipodemovimiento.Movible;
import ajedrez.model.tipodemovimiento.MovimientoSinRango;


public class Torre extends Ficha{
    private Boolean primerMovimiento = true;
    private Movible tipoDeMovimiento = new MovimientoSinRango(this);
    private final int COLUMNA_REY = 4;
    private final int FILA_REY = (this.getNumJugador() == NumJugador.UNO)?  0 : 7;

    public Torre (String id, NumJugador numJugador) {
        super("Torre", id, numJugador);
    }

    public  HashMap<Integer, ArrayList<Integer>> verificarMovimientosPosibles(Tablero tablero){
        var movimientos = new HashMap<Integer, ArrayList<Integer>>(); 
        int[] direcciones_y = { 1, -1, 0, 0};
        int[] direcciones_x = { 0, 0, 1, -1};
        for (int indice = 0; indice < direcciones_x.length; indice++){
            tipoDeMovimiento.movimientosValidos(tablero, direcciones_y[indice], direcciones_x[indice], movimientos);
        }
        return movimientos;
    }

    @Override
    public Boolean mover(int fila, int columna, Tablero tablero) {
        if (!tablero.estaLaFicha(this)) return false;
        setCaptura(null);
        var movimientos = verificarMovimientosPosibles(tablero);
        if (torreCumpleRequisitosEnroque(fila, columna) && reyCumpleRequisitosEnroque(tablero, movimientos)){
            enroque(tablero);
            return true;
        } 
        if(movimientos.containsKey(fila) && movimientos.get(fila).contains(columna)) {
            this.primerMovimiento = false;
            verificarFichaSacada(tablero, fila, columna);
            return true;
        }
        return false;
    }

    private Boolean torreCumpleRequisitosEnroque(int fila, int columna) {
        if (!this.primerMovimiento) 
            return false;
        if ((fila != FILA_REY) || (columna != COLUMNA_REY)) 
            return false;
        return true;
    }

    private Boolean reyCumpleRequisitosEnroque(Tablero tablero, HashMap<Integer, ArrayList<Integer>> movimientos) {
        var fichaRey = tablero.getFicha(this.FILA_REY, 4);
        if (fichaRey == null) 
            return false;
        if (!(fichaRey.getNombre().equals("Rey")) || fichaRey.getNumJugador() != getNumJugador()) 
            return false;
        if (!movimientos.containsKey(this.FILA_REY) || !((Rey)fichaRey).getPrimerMovimiento()) 
            return false;
        var posicionActual = tablero.ubicacionActualFicha(this);
        int columnaActual = posicionActual.get(1);
        if (columnaActual == 0 && movimientos.get(this.FILA_REY).size() == 3) 
            return true;
        if (columnaActual == 7 && movimientos.get(this.FILA_REY).size() == 2) 
            return true;
        return false;
    }

    private void enroque(Tablero tablero) {
        var rey = tablero.getFicha(this.FILA_REY, COLUMNA_REY);
        var posicionActual = tablero.ubicacionActualFicha(this);
        int columnaActual = posicionActual.get(1);
        if(columnaActual == 0){
            aplicarEnroque(tablero, rey, 2, 3);
            return;
        }
        aplicarEnroque(tablero, rey, 6, 5);
    }

    private void aplicarEnroque(Tablero tablero, Ficha rey,int nuevaColumnaRey, int nuevaColumnaTorre) {
        tablero.sacarFicha(rey);
        tablero.colocarFicha(rey, this.FILA_REY, nuevaColumnaRey);
        tablero.sacarFicha(this);
        tablero.colocarFicha(this, this.FILA_REY, nuevaColumnaTorre);
    }

}
