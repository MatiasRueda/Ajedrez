package ajedrez.model.tipoficha;

import java.util.ArrayList;
import java.util.HashMap;

import ajedrez.App.NumJugador;
import ajedrez.model.Tablero;
import ajedrez.model.publisher.Ficha;


public class Caballo extends Ficha{
    private HashMap<Integer, ArrayList<Integer>> movimientos;
    private Tablero tablero;

    
    public Caballo (String id, NumJugador numJugador) {
        super("Caballo", id, numJugador);
    }
    
    public  HashMap<Integer, ArrayList<Integer>> verificarMovimientosPosibles(Tablero tablero){
        this.movimientos = new HashMap<Integer, ArrayList<Integer>>();
        this.tablero = tablero;
        int[] direcciones_y = {1, -1, 0, 0};
        int[] direcciones_x = {0, 0, 1, -1};
        for (int indice = 0; indice < direcciones_x.length; indice++) {
            movimientosValidos(tablero, direcciones_y[indice], direcciones_x[indice]);
        } 
        return this.movimientos;
    }

    private void movimientosValidos(Tablero tablero, int y, int x){
        var ubicacion = tablero.ubicacionActualFicha(this); // devuelve un ArrayList con fila(indice 0) y columna(indice 1) 
        var filaActual = ubicacion.get(0) + (y*2);
        var columnaActual = ubicacion.get(1) + (x*2);
        if (tablero.posicionFueraDelTablero(filaActual, columnaActual)) return;

        int z = x;
        x = y;
        y = z;

        movimientosHaciaLosCostados(filaActual, columnaActual, y, x);      
    }

    private void movimientosHaciaLosCostados(int filaActual, int columnaActual, int y, int x) {
        for (int i = 0; i < 2; i++) {
            int filPosible = filaActual; 
            int colPosible = columnaActual;
            y *= -1;
            x *= -1;
            filPosible += y;
            colPosible += x;
            movimientos(filPosible, colPosible);
        }
    }

    private void movimientos(int filPosible, int colPosible) {
        if (this.tablero.posicionFueraDelTablero(filPosible, colPosible)) 
            return;

        if (!this.tablero.posicionOcupada(filPosible, colPosible) ) {
            if(!this.movimientos.containsKey(filPosible)) 
                this.movimientos.put(filPosible, new ArrayList<>());
            this.movimientos.get(filPosible).add(colPosible);
        }

        if (this.tablero.posicionOcupada(filPosible, colPosible)) 
            posibleFichaRival(filPosible, colPosible);

    }

    private void posibleFichaRival(int filPosible, int colPosible){
        if (this.tablero.getFicha(filPosible, colPosible).getNumJugador() != getNumJugador()) {
            if(!this.movimientos.containsKey(filPosible))
                this.movimientos.put(filPosible, new ArrayList<>());
            this.movimientos.get(filPosible).add(colPosible);
        }
    }
}