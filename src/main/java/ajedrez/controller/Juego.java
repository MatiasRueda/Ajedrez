package ajedrez.controller;

import ajedrez.model.Ajedrez;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class Juego {
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
    private StackPane StackPane;

    @FXML
    private VBox fondo;

    private Ajedrez ajedrez;
    private Registros registros;

    public Juego() {
        musica.musicaJuegoPlay();
    }

    @FXML
    void initialize() {
        this.ajedrez = new Ajedrez();
        this.registros = new Registros(registroUNO, registroDOS);
        new Tablero(this.ajedrez, this.registros,  new Turno(turnoJugador), this.gridPaneID);
    }
}
    