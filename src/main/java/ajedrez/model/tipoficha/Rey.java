package ajedrez.model.tipoficha;

import java.util.ArrayList;
import java.util.HashMap;

import ajedrez.model.JUGADOR;
import ajedrez.model.Tablero;
import ajedrez.model.publisher.Ficha;
import ajedrez.model.tipodemovimiento.Movible;
import ajedrez.model.tipodemovimiento.MovimientoConRango;


public class Rey extends Ficha{
    private final int RANGO = 1;
    private Movible tipoDeMovimiento = new MovimientoConRango(this, RANGO);
    private Boolean primerMovimiento = true;

    public Rey (String id, JUGADOR jugador) {
        super("Rey", id, jugador);
    }

    public Boolean getPrimerMovimiento() {
        return this.primerMovimiento;
    }

    public  HashMap<Integer, ArrayList<Integer>> verificarMovimientosPosibles(Tablero tablero){
        var movimientos = new HashMap<Integer, ArrayList<Integer>>();
        int[] direcciones_y = { 1, -1, 0, 0, 1, -1, 1, -1};
        int[] direcciones_x = { 0, 0, 1, -1, 1, -1, -1, 1};
        for (int indice = 0; indice < direcciones_x.length; indice++){
            tipoDeMovimiento.movimientosValidos(tablero, direcciones_y[indice], direcciones_x[indice], movimientos);
        }
        return movimientos;
    }


    @Override
    public Boolean mover(int fila, int columna, Tablero tablero) {
        if (!tablero.estaLaFicha(this)) return false;
        setCaptura(null);
        var movimientos = getMovimientos();
        if(movimientos.containsKey(fila) && movimientos.get(fila).contains(columna)) {
            verificarFichaSacada(tablero, fila, columna);
            this.primerMovimiento = false;
            return true;
        }
        return false;
    }
}
