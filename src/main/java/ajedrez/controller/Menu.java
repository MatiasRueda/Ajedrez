package ajedrez.controller;

import ajedrez.view.CargarEscena;
import ajedrez.view.Musica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;


public class Menu {

    @FXML
    private Button botonAjedrez;

    @FXML
    private Pane menu;

    private CargarEscena cargarEscena = new CargarEscena();

    @FXML
    void clickJugar(ActionEvent event) {
        Musica.stopMusicaFondo();
        cargarEscena.cargarSiguienteScena(this.menu, "tablero");
    }
}
