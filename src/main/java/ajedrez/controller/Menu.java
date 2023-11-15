package ajedrez.controller;

import java.io.IOException;

import ajedrez.view.Musica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;


public class Menu {
    public final static Escenas escenas = new Escenas();

    @FXML
    private Button botonAjedrez;

    @FXML
    private Pane menu;

    @FXML
    void clickJugar(ActionEvent event) throws IOException {
        Musica.stopMusicaFondo();
        escenas.cambiarEscena("tablero");
    }
}
