package ajedrez.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Menu {
    public final static Escenas escenas = new Escenas();
    public final static Musica musica = new Musica();

    @FXML
    private GridPane menu;

    @FXML
    private StackPane inicio;


    public Menu() {
        musica.musicaFondoPlay(MUSICA_FONDO.INTRO);
    } 

    @FXML
    void jugar(ActionEvent event) throws IOException {
        escenas.cambiarEscena(ESCENA.JUEGO);
    }

    @FXML
    void configuracion(ActionEvent event) throws IOException {
        Pane configuracion = (Pane) escenas.loadFXML(ESCENA.CONFIGURACION);
        this.menu.getChildren().remove(1);
        this.menu.add(configuracion, 1, 0);
    }

    @FXML
    void creditos(ActionEvent event) throws IOException {
        Pane creditos = (Pane) escenas.loadFXML(ESCENA.CREDITOS);
        this.menu.getChildren().remove(1);
        this.menu.add(creditos, 1, 0);
    }

    @FXML
    void salir(ActionEvent event) {
        Button boton = ((Button)event.getSource());
        Stage sta = (Stage) boton.getScene().getWindow();
        sta.close();
    }
}
