package ajedrez.model.tipodemovimiento;

import java.util.ArrayList;
import java.util.HashMap;

import ajedrez.model.Tablero;
import ajedrez.model.publisher.Ficha;

public class MovimientoSinRango implements Movible {
    private Ficha ficha;

    public MovimientoSinRango(Ficha ficha) {
        this.ficha = ficha;
    }

    @Override
    public void movimientosValidos(Tablero tablero, int y, int x, HashMap<Integer, ArrayList<Integer>> movimientos) {
        var ubicacion = tablero.ubicacionActualFicha(this.ficha);  
        var filPosible = ubicacion.get(0) + y;
        var colPosible = ubicacion.get(1) + x;
        if (tablero.posicionFueraDelTablero(filPosible, colPosible)) return;
        while (!tablero.posicionOcupada(filPosible, colPosible)) {
            if(!movimientos.containsKey(filPosible)) 
                movimientos.put(filPosible, new ArrayList<>());
            movimientos.get(filPosible).add(colPosible);
            filPosible += y;
            colPosible += x;
            if (tablero.posicionFueraDelTablero(filPosible, colPosible))
                return;
        }

        var fichaElegida = tablero.getFicha(filPosible, colPosible);
        if (fichaElegida.getNumJugador() != this.ficha.getNumJugador()) {
            if(!movimientos.containsKey(filPosible)) 
                movimientos.put(filPosible, new ArrayList<>());
            movimientos.get(filPosible).add(colPosible);
        }
    }
}
