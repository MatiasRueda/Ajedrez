package ajedrez.controller;

import ajedrez.model.Juego;
import ajedrez.view.Registros;
import ajedrez.view.TableroGrafico;
import ajedrez.view.Turno;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
    private StackPane ajedrez;

    private Juego juego;
    private Registros registros;

    public Tablero() {
        musica.musicaJuegoPlay();
    }

    @FXML
    void initialize() {
        this.juego = new Juego();
        this.registros = new Registros(registroUNO, registroDOS);
        new TableroGrafico(this.juego, this.registros,  new Turno(turnoJugador), this.gridPaneID);
    }
}
    