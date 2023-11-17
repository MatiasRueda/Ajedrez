package ajedrez.model.tipoficha;

import java.util.HashMap;
import java.util.ArrayList;

import ajedrez.model.FICHA;
import ajedrez.model.JUGADOR;
import ajedrez.model.Tablero;
import ajedrez.model.publisher.Ficha;
import ajedrez.model.tipodemovimiento.Movible;
import ajedrez.model.tipodemovimiento.MovimientoPeon;

public class Peon extends Ficha{
    private Movible tipoDeMovimiento;
    private final int RANGO_PRIMER_MOVIMIENTO = 2;
    private final int RANGO_NORMAL = 1;
    private final int DIRECCION_Y_JUGADOR_UNO = 1;
    private final int DIRECCION_Y_JUGADOR_DOS = -1;
    private final int DIRECCION_X = 0;
    private final int DIRECCION_Y = (this.getJugador() == JUGADOR.UNO)?  DIRECCION_Y_JUGADOR_UNO : DIRECCION_Y_JUGADOR_DOS;

    public Peon(String id, JUGADOR jugador) {
        super(FICHA.PEON, id, jugador);
        this.tipoDeMovimiento = new MovimientoPeon(this, RANGO_PRIMER_MOVIMIENTO);
    }

    public HashMap<Integer, ArrayList<Integer>> movPosibles(Tablero tablero){
        var movimientos = new HashMap<Integer, ArrayList<Integer>>();
        tipoDeMovimiento.movimientosValidos(tablero, DIRECCION_Y, DIRECCION_X, movimientos);
        int[] direcciones_x_oblicua = {1, -1};
        int[] direcciones_y_oblicua = {DIRECCION_Y, DIRECCION_Y}; 
        for (int indice = 0; indice < direcciones_x_oblicua.length; indice++){
            tipoDeMovimiento.movimientosValidos(tablero, direcciones_y_oblicua[indice], direcciones_x_oblicua[indice], movimientos);
        }
        return movimientos;
    }

    @Override
    public Boolean mover(int fila, int col, Tablero tablero) {
        if (!tablero.estaLaFicha(this)) return false;
        setCaptura(null);
        var movimientos = movPosibles(tablero);
        if(movimientos.containsKey(fila) && movimientos.get(fila).contains(col)) {
            this.tipoDeMovimiento = new MovimientoPeon(this, RANGO_NORMAL);
            verificarFichaSacada(tablero, fila, col);
            return true;
            
        }
        return false;
    }
}
