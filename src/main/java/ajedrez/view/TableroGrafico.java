package ajedrez.view;

import java.util.ArrayList;
import ajedrez.model.Juego;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class TableroGrafico{
    private GridPane tablero;
    private Juego juego;
    private Registros registros;
    private String color;
    private boolean casilleroBlanco = true;
    private RegistroBotones registroBtn = new RegistroBotones();
    private Estilo botonesTablero = new Estilo();
    private Accion botonesTableroLogica;
    
    public TableroGrafico(Juego juego, Registros registros, Turno turno, GridPane tablero){
        this.juego = juego;
        this.tablero = tablero;
        this.registros = registros;
        turno.nuevoTurno(this.juego.getTurnoUsuario());
        this.botonesTableroLogica = new Accion(this.registroBtn, this.juego, turno, this.registros);
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
            Button btn = botonesTablero.crearBotonPersonalizado(nombreDeLaFicha, color, this.casilleroBlanco);
            botonesTableroLogica.agregarLogicaAlBoton(btn);
            this.casilleroBlanco = (this.casilleroBlanco)? false : true;
            indiceNombres++;

            if ((indiceNombres % 8) == 0) {
                this.casilleroBlanco = (this.casilleroBlanco)? false : true;
            } 
            this.tablero.add(btn, columnas, filas);
            this.registroBtn.add(filas, columnas, btn, btn.getStyle());
        }
    }
}

