package ajedrez.view;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.control.Button;

public class RegistroBotones {
    private HashMap<Integer, HashMap<Integer, Button>> ubicacionBotones = new HashMap<>();
    private HashMap<Integer, HashMap<Integer, String>> coloresOriginales = new HashMap<>();
    private HashMap<Integer, ArrayList<Integer>> posicionesValidas;

    public void add(int fila, int columna, Button btn, String color) {
        if (!this.ubicacionBotones.containsKey(fila)) this.ubicacionBotones.put(fila, new HashMap<>());
        var columnas = this.ubicacionBotones.get(fila);
        columnas.put(columna, btn);

        if (!this.coloresOriginales.containsKey(fila)) this.coloresOriginales.put(fila, new HashMap<>());
        var columnasColores = this.coloresOriginales.get(fila);
        columnasColores.put(columna, color);
    }

    public Button getBtn(int fila, int columna) {
        var columnas = this.ubicacionBotones.get(fila);
        return columnas.get(columna);
    }


    private String getColor(int fila, int columna) {
        var columnas = this.coloresOriginales.get(fila);
        return columnas.get(columna);
    }


    private void coloreo(int fila, ArrayList<Integer> columnas) {
        columnas.forEach((colum) -> getBtn(fila, colum).setStyle("-fx-background-color: red"));
    }

    private void coloreoOriginal(int fila, ArrayList<Integer> columnas) {
        columnas.forEach((colum) -> getBtn(fila, colum).setStyle(getColor(fila, colum)));
    }

    public void setPosicionesValidas(HashMap<Integer, ArrayList<Integer>> posiciones) {
        this.posicionesValidas = posiciones;
    }

    public void colorearPosiciones() {
        if (this.posicionesValidas == null) return;
        this.posicionesValidas.forEach((k,v) -> coloreo(k, v));
    }

    public void colorearPosicionesOriginales() {
        this.posicionesValidas.forEach((k,v) -> coloreoOriginal(k, v));
    }


}