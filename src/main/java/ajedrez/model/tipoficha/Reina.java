package ajedrez.model.tipoficha;

import java.util.ArrayList;
import java.util.HashMap;

import ajedrez.App.NumJugador;
import ajedrez.model.Tablero;
import ajedrez.model.publisher.Ficha;
import ajedrez.model.tipodemovimiento.Movible;
import ajedrez.model.tipodemovimiento.MovimientoSinRango;


public class Reina extends Ficha{
    private Movible tipoDeMovimiento = new MovimientoSinRango(this);

    public Reina (String id, NumJugador numJugador) {
        super("Reina", id, numJugador);
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
}