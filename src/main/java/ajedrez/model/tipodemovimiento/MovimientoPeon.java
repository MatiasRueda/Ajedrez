package ajedrez.model.tipodemovimiento;

import java.util.ArrayList;
import java.util.HashMap;

import ajedrez.model.Tablero;
import ajedrez.model.publisher.Ficha;

public class MovimientoPeon implements Movible{
    private Ficha ficha;
    private int rango;

    public MovimientoPeon(Ficha peon, int rango) {
        this.ficha = peon;
        this.rango = rango;
    }

    @Override
    public void movimientosValidos(Tablero tablero, int y, int x, HashMap<Integer, ArrayList<Integer>> movimientos) {
        var ubicacion = tablero.ubicacionActualFicha(this.ficha);  
        var filPosible = ubicacion.get(0) + y;
        var colPosible = ubicacion.get(1) + x;
        if (tablero.posicionFueraDelTablero(filPosible, colPosible)) return;

        if ((y != 0 && x != 0) && tablero.posicionOcupada(filPosible, colPosible)) {
            var fichaElegida = tablero.getFicha(filPosible, colPosible);
            if (fichaElegida.getNumJugador() != this.ficha.getNumJugador()) {
                if(!movimientos.containsKey(filPosible)) movimientos.put(filPosible, new ArrayList<>());
                    movimientos.get(filPosible).add(colPosible);
            }
            return;
        }

        if( (y != 0 && x != 0) && !tablero.posicionOcupada(filPosible, colPosible)) {
            return;
        }

        if (tablero.posicionOcupada(filPosible, colPosible)) return;
        var casillasAVerificar = this.rango;
        while (!tablero.posicionOcupada(filPosible, colPosible)) {
            if(!movimientos.containsKey(filPosible)) movimientos.put(filPosible, new ArrayList<>());
            movimientos.get(filPosible).add(colPosible);
            filPosible += y;
            colPosible += x;
            casillasAVerificar -= 1;
            if (tablero.posicionFueraDelTablero(filPosible, colPosible) || casillasAVerificar == 0) return;
        }
        
    }

}
