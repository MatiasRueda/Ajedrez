package ajedrez.controller;

import ajedrez.model.FICHA;
import ajedrez.view.ImagenBoton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Fichas {
    private ImagenBoton imagenBoton = new ImagenBoton();
    private String opcion;
    private String color;
    private final int TAMANIO = 80;

    @FXML
    private Button botonTorre;

    @FXML
    private Button botonAfil;

    @FXML
    private Button botonReina;

    @FXML
    private Button botonCaballo;

    private FICHA getFicha(String opcion) {
        if (opcion.toUpperCase().equals(FICHA.PEON.toString())) 
            return FICHA.PEON;
        else if (opcion.toUpperCase().equals(FICHA.CABALLO.toString())) 
            return FICHA.CABALLO;
        else if (opcion.toUpperCase().equals(FICHA.AFIL.toString())) 
            return FICHA.AFIL;
        else if (opcion.toUpperCase().equals(FICHA.REINA.toString())) 
            return FICHA.REINA;
        else 
            return FICHA.TORRE;
    }
    

    public FICHA getOpcion() {
        return getFicha(this.opcion);
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
        Button boton = ((Button)event.getSource());
        this.opcion = boton.getText();
        Stage stage = (Stage) boton.getScene().getWindow();
        stage.close();
    }
}
