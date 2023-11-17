package ajedrez.controller;

import java.util.ArrayList;
import ajedrez.model.Ajedrez;
import ajedrez.view.BotonTablero;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Tablero{
    private GridPane tablero;
    private Ajedrez juego;
    private Registros registros;
    private String color;
    private boolean casilleroBlanco = true;
    private ControlBotones control = new ControlBotones();
    private BotonTablero botonTablero = new BotonTablero();
    private Accion botonTableroLogica;
    
    public Tablero(Ajedrez juego, Registros registros, Turno turno, GridPane tablero){
        this.juego = juego;
        this.tablero = tablero;
        this.registros = registros;
        turno.nuevoTurno(this.juego.getTurnoUsuario());
        this.botonTableroLogica = new Accion(this.control, this.juego, turno, this.registros);
        agregarBotones();
    }

    private void agregarBotones() {
        int indiceNombres = 0;
        var nombresFichas = this.juego.getTablero();
        for(int filas = 0; filas < 8; filas++) {
            agregarBotonPorCasilla(filas, nombresFichas, indiceNombres);
            indiceNombres += 8;
        }
    }

    private void agregarBotonPorCasilla(int filas, ArrayList<ArrayList<String>> nombresFichas, int indiceNombres) {
        for(int columnas = 0; columnas < 8; columnas++) {
            String nombreDeLaFicha = nombresFichas.get(indiceNombres).get(0);
            this.color = (nombresFichas.get(indiceNombres).get(1).equals("UNO"))? "blanco" : "negro";
            Button btn = botonTablero.crear(nombreDeLaFicha, color, this.casilleroBlanco);
            botonTableroLogica.agregarLogicaAlBoton(btn);
            this.casilleroBlanco = (this.casilleroBlanco)? false : true;
            indiceNombres++;

            if ((indiceNombres % 8) == 0) {
                this.casilleroBlanco = (this.casilleroBlanco)? false : true;
            } 
            this.tablero.add(btn, columnas, filas);
            this.control.add(filas, columnas, btn, btn.getStyle());
        }
    }
}

