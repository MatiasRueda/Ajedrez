package ajedrez.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Menu {
    public final static Escenas escenas = new Escenas();
    public final static Musica musica = new Musica();


    public Menu() {
        musica.musicaFondoPlay(MUSICA_FONDO.INTRO);
    } 

    @FXML
    void jugar(ActionEvent event) throws IOException {
        escenas.cambiarEscena(ESCENA.JUEGO);
    }
}
