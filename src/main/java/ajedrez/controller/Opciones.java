package ajedrez.controller;

import ajedrez.view.ImagenBoton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Opciones {
    private ImagenBoton imagenBoton = new ImagenBoton();
    private final int TAMANIO = 80;

    @FXML
    private Button botonTorre;

    @FXML
    private Button botonAfil;

    @FXML
    private Button botonReina;

    @FXML
    private Button botonCaballo;


    private String opcionElegida;

    private String color;
    

    public String getOpcionElegida() {
        return this.opcionElegida;
    }

    public void agregarImagenes() {
        imagenBoton.colocarImagen(botonTorre.getText(), this.color, botonTorre, TAMANIO);
        imagenBoton.colocarImagen(botonAfil.getText(), this.color, botonAfil, TAMANIO);
        imagenBoton.colocarImagen(botonReina.getText(), this.color, botonReina, TAMANIO);
        imagenBoton.colocarImagen(botonCaballo.getText(), this.color, botonCaballo, TAMANIO);
    }

    public void setColor(String color) {
        this.color = color;
    }

    @FXML
    void click(ActionEvent event) {
        this.opcionElegida = botonTorre.getText();
        Stage stage = (Stage) this.botonTorre.getScene().getWindow();
        stage.close();
    }


    @FXML
    void click2(ActionEvent event) {
        this.opcionElegida = botonAfil.getText();
        Stage stage = (Stage) this.botonAfil.getScene().getWindow();
        stage.close();
    }

    @FXML
    void click3(ActionEvent event) {
        this.opcionElegida = botonReina.getText();
        Stage stage = (Stage) this.botonReina.getScene().getWindow();
        stage.close();
    }

    @FXML
    void click4(ActionEvent event) {
        this.opcionElegida = botonCaballo.getText();
        Stage stage = (Stage) this.botonCaballo.getScene().getWindow();
        stage.close();
    }
}
