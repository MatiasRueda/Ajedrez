package ajedrez.view;

import java.util.ArrayList;
import ajedrez.model.Juego;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class TableroGrafico{
    private GridPane panel;
    private Juego juego;
    private RegistroGraficos registroInfo;
    private String color;
    private boolean casilleroBlanco = true;
    private RegistroBotones registroBtn = new RegistroBotones();
    private BotonesEstilo botonesTablero = new BotonesEstilo();
    private BotonesLogica botonesTableroLogica;
    
    public TableroGrafico(Juego juego, RegistroGraficos registro, GridPane panel){
        this.juego = juego;
        this.panel = panel;
        this.registroInfo = registro;
        this.registroInfo.nuevoTurno(this.juego.getTurnoUsuario());
        this.botonesTableroLogica = new BotonesLogica(this.registroBtn, this.juego, this.registroInfo, this.panel);
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
            this.panel.add(btn, columnas, filas);
            this.registroBtn.add(filas, columnas, btn, btn.getStyle());
        }
    }
}

