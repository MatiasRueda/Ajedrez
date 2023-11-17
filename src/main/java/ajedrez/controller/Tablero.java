package ajedrez.controller;

import ajedrez.model.Juego;
import ajedrez.view.RegistroGraficos;
import ajedrez.view.TableroGrafico;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;

public class Tablero {
    private Musica musica = Menu.musica;

    @FXML
    private GridPane gridPaneID;

    @FXML
    private HBox hboxID;
    
    @FXML
    private TilePane registroUNO;

    @FXML
    private TilePane registroDOS;

    @FXML
    private Label turnoJugador;

    @FXML
    private TableroGrafico tableroGrafico;

    private Juego juego;
    private RegistroGraficos registro;

    public Tablero() {
        musica.musicaJuegoPlay();
    }

    @FXML
    void initialize() {
        this.juego = new Juego();
        this.registro = new RegistroGraficos(registroUNO, registroDOS, turnoJugador);
        this.tableroGrafico = new TableroGrafico(this.juego, this.registro, this.gridPaneID);
    }
}
    