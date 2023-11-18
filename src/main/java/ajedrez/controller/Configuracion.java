package ajedrez.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;

public class Configuracion {
    private Musica musica = ajedrez.controller.Menu.musica;

    @FXML
    private Button aceptar;

    @FXML
    private Slider volumenEfecto;

    @FXML
    private Slider volumenMusica;

    @FXML
    void initialize() {
        volumenEfecto.setValue(musica.getEfecto());
        volumenMusica.setValue(musica.getMusica());
    }

    @FXML
    void aceptar(ActionEvent event) {
        musica.setEfecto(this.volumenEfecto.getValue());
        musica.setMusica(this.volumenMusica.getValue());
    }

}