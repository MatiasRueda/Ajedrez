package ajedrez.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Ganador {
    public String opcion;

    @FXML
    private Label ganador;

    @FXML
    private Button menuBtn;

    @FXML
    private Button reiniciarBtn;

    public void setMensaje(String Jugador) {
        this.ganador.setText("Felicidades jugador " + Jugador + " ganaste!!!");
    }

    public String getOpcion() {
        return this.opcion;
    }

    @FXML
    void menu(ActionEvent event) {
        this.opcion = menuBtn.getText();
        Stage sta = (Stage) this.menuBtn.getScene().getWindow();
        sta.close();
    }

    @FXML
    void reiniciar(ActionEvent event) {
        this.opcion = reiniciarBtn.getText();
        Stage sta = (Stage) this.reiniciarBtn.getScene().getWindow();
        sta.close();
    }


}
