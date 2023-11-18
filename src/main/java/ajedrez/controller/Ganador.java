package ajedrez.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Ganador {
    public String opcion;

    @FXML
    private Label jugadorGanador;

    @FXML
    private Button menuBtn;

    @FXML
    private Button reiniciarBtn;

    public void setMensaje(String Jugador) {
        this.jugadorGanador.setText("Felicidades jugador " + Jugador + " ganaste!!!");
    }

    public String getOpcion() {
        return this.opcion;
    }

    @FXML
    void eleccion(ActionEvent event) {
        Button boton = ((Button)event.getSource());
        this.opcion = boton.getText();
        Stage sta = (Stage) boton.getScene().getWindow();
        sta.close();
    }

}
