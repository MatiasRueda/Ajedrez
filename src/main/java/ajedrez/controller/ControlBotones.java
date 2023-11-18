package ajedrez.controller;

import java.util.ArrayList;
import java.util.HashMap;

import ajedrez.view.BotonTablero;
import javafx.scene.control.Button;

public class ControlBotones {
    private HashMap<Integer, HashMap<Integer, Button>> ubicacionBotones = new HashMap<>();
    private BotonTablero botonTablero = new BotonTablero();
    private HashMap<Integer, ArrayList<Integer>> posicionesValidas;

    public void add(int fila, int columna, Button btn, String color) {
        if (!this.ubicacionBotones.containsKey(fila)) 
            this.ubicacionBotones.put(fila, new HashMap<>());
        var columnas = this.ubicacionBotones.get(fila);
        columnas.put(columna, btn);
    }

    public Button getBtn(int fila, int columna) {
        var columnas = this.ubicacionBotones.get(fila);
        return columnas.get(columna);
    }

    private void coloreo(int fila, ArrayList<Integer> columnas) {
        columnas.forEach((colum) -> botonTablero.colorPosiblePosicion(getBtn(fila, colum)));
    }
    private void coloreoOriginal(int fila, ArrayList<Integer> columnas) {
        columnas.forEach((colum) -> botonTablero.colorOriginal(getBtn(fila, colum)));
    }

    public void setPosicionesValidas(HashMap<Integer, ArrayList<Integer>> posiciones) {
        this.posicionesValidas = posiciones;
    }

    public void colorearPosiciones() {
        if (this.posicionesValidas == null) return;
        this.posicionesValidas.forEach((fila, columnas) -> coloreo(fila, columnas));
    }

    public void colorearPosicionesOriginales() {
        this.posicionesValidas.forEach((fila, columnas) -> coloreoOriginal(fila, columnas));
    }

}