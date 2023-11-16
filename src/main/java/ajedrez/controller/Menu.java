package ajedrez.controller;

import java.io.IOException;

import ajedrez.view.Musica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Menu {
    public final static Escenas escenas = new Escenas();

    @FXML
    void jugar(ActionEvent event) throws IOException {
        Musica.stopMusicaFondo();
        escenas.cambiarEscena(ESCENA.TABLERO);
    }
}
