package ajedrez.controller;

import ajedrez.model.Ajedrez;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class Juego {
    private Musica musica = Menu.musica;
    private boolean pausada = false;

    @FXML
    private GridPane gridPaneID;

    @FXML
    private HBox hboxID;
    
    @FXML
    private Button btnMusica;

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
        musica.musicaFondoPlay(MUSICA_FONDO.JUEGO);
    }

    @FXML
    void initialize() {
        this.btnMusica.setText(MUSICA_CONTROL.PAUSAR.getTexto());
        this.ajedrez = new Ajedrez();
        this.registros = new Registros(registroUNO, registroDOS);
        new Tablero(this.ajedrez, this.registros,  new Turno(turnoJugador), this.gridPaneID);
    }

    @FXML
    void controlarMusica(ActionEvent event) {
        if (pausada) {
            musica.musicaFondoPlay(MUSICA_FONDO.JUEGO);
            this.pausada = false;
            this.btnMusica.setText(MUSICA_CONTROL.PAUSAR.getTexto());
            return;
        }
        musica.pausarMusicaFondo();
        this.pausada = true;
        this.btnMusica.setText(MUSICA_CONTROL.PLAY.getTexto());
    }

}
    