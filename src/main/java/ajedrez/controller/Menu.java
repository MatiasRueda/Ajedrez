package ajedrez.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Menu {
    public final static Escenas escenas = new Escenas();
    public final static Musica musica = new Musica();


    public Menu() {
        musica.musicaIntroPlay();
    } 

    @FXML
    void jugar(ActionEvent event) throws IOException {
        Musica.stopMusicaFondo();
        escenas.cambiarEscena(ESCENA.TABLERO);
    }
}
