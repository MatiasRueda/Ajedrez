package ajedrez.model;

import java.util.ArrayList;
import java.util.HashMap;

import ajedrez.model.publisher.Ficha;

public class ControladorJaque {
    private Tablero tablero;
    private HashMap<Integer, ArrayList<Integer>> movimientosPosibles;

    public ControladorJaque(Tablero tablero) {
        this.tablero = tablero;
    }

    public void setMovPosibles(HashMap<Integer, ArrayList<Integer>> mov) {
        this.movimientosPosibles = mov;
    }
    
    public HashMap<Integer, ArrayList<Integer>> posibleJaque(Usuario rival, Ficha ficha) {
        HashMap<Integer, ArrayList<Integer>> mov  = new HashMap<>();
        var ubicacion = this.tablero.ubicacionActualFicha(ficha);
        int filaOriginal = ubicacion.get(0);
        int colOriginal =  ubicacion.get(1);
        this.tablero.sacarFicha(ficha);
        recorrerMovimientos(ficha, rival, mov);
        this.tablero.colocarFicha(ficha, filaOriginal, colOriginal);
        return mov;

    }

    private void recorrerMovimientos(Ficha ficha, Usuario rival, HashMap<Integer, ArrayList<Integer>> mov) {
        for (int fila : this.movimientosPosibles.keySet()) {
            var columnas = this.movimientosPosibles.get(fila);
            var columnasAgregar = new ArrayList<Integer>();
            recorrecColumnas(ficha, fila, columnas, rival, columnasAgregar);
            if(columnasAgregar.isEmpty()) continue;
            mov.put(fila, columnasAgregar);
        }

    }

    private void recorrecColumnas(Ficha ficha, int fila, ArrayList<Integer> columnas, Usuario rival,  ArrayList<Integer> colum)  {
        for (int columna : columnas) {
            Ficha fichaSacada;
            fichaSacada = this.tablero.colocarFicha(ficha, fila, columna);
            if (fichaSacada != null) {
                rival.sacarFicha(fichaSacada);
            }
 
            if (rival.buscandoJaque()) {
                this.tablero.sacarFicha(ficha);
                if (fichaSacada != null) {
                    this.tablero.colocarFicha(fichaSacada, fila, columna);
                    rival.agregarFichaAlasDisponibles(fichaSacada);
                }
                continue;
            }
            colum.add(columna);
            this.tablero.sacarFicha(ficha);
            if (fichaSacada != null) {
                this.tablero.colocarFicha(fichaSacada, fila, columna);
                rival.agregarFichaAlasDisponibles(fichaSacada);
            }
        }
    }

}
