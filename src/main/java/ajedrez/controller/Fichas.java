package ajedrez.controller;

import ajedrez.model.FICHA;
import ajedrez.view.Imagen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Fichas {
    private Imagen imagenBoton = new Imagen();
    private String opcion;
    private String color;
    private final int TAMANIO = 80;

    @FXML
    private VBox fichas;

    @FXML
    private Button btnTorre;

    @FXML
    private Button btnAfil;

    @FXML
    private Button btnReina;

    @FXML
    private Button btnCaballo;

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
        imagenBoton.colocarImagen(btnTorre.getText(), this.color, btnTorre, TAMANIO);
        imagenBoton.colocarImagen(btnAfil.getText(), this.color, btnAfil, TAMANIO);
        imagenBoton.colocarImagen(btnReina.getText(), this.color, btnReina, TAMANIO);
        imagenBoton.colocarImagen(btnCaballo.getText(), this.color, btnCaballo, TAMANIO);
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
