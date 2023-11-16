package ajedrez.controller;

import javafx.util.Duration;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


public class Intro {
    private Escenas escenas = Menu.escenas;

    @FXML
    private Pane intro;

    @FXML
    private Label presentacion;


    @FXML
    void initialize() {
        transition(presentacion, 0, 1).setOnFinished(e -> {
            desaparecerPresentacion();
        });
    }

    private void desaparecerPresentacion() {
        transition(presentacion, 1, 0).setOnFinished(e -> {
            animacionEscena();
        });
    }
    
    private void animacionEscena() {
        cambiarLabel();
        transition(presentacion, 0, 1).setOnFinished(e2 ->{ 
            animacionEscena2();
        });
    }

    private void animacionEscena2() {
        transition(presentacion, 1, 0).setOnFinished(e3 -> {
            try {
            escenas.cambiarEscena(ESCENA.MENU);
            } catch (IOException error) {
                System.out.println(error);
            }
        });
    }

    private FadeTransition transition(Node nodo, int desdeElValor, int hastaElValor) {
        FadeTransition ft = new FadeTransition(Duration.millis(2000), presentacion);
        ft.setFromValue(desdeElValor);
        ft.setToValue(hastaElValor);
        ft.play();
        return ft;
    }

    private void cambiarLabel() {
        presentacion.setText("Programado por: \n  Matias Rueda ");
    }
    
}
