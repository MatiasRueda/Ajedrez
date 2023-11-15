package ajedrez.model.tipodemovimiento;

import java.util.ArrayList;
import java.util.HashMap;

import ajedrez.model.Tablero;

public interface Movible {

    /* Metodo creado para poder saber todos los movimientos validos que se podran hacer
    *  sobre el tablero que se le pase por parametro, estos movimientos se almacenaran en el hash
    *  "movimientos" que sera pasado por parametro. Mientras que "x" e "y" indican hacia que lugares
    *  se quieren averiguar los posibles movimientos
    */
    void movimientosValidos(Tablero tablero, int y, int x, HashMap<Integer, ArrayList<Integer>> movimientos);
}
