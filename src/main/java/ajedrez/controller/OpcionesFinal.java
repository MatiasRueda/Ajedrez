package ajedrez.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class OpcionesFinal {

    @FXML
    private Label ganador;

    @FXML
    private Button menuBtn;

    @FXML
    private Button reiniciarBtn;

    private String op;

    public String getOpFinal() {
        return this.op;
    }

    public void setMensaje(String Jugador) {
        this.ganador.setText("Felicidades jugador " + Jugador + " ganaste!!!");
    }

    @FXML
    void menu(ActionEvent event) {
        this.op = menuBtn.getText();
        Stage sta = (Stage) this.menuBtn.getScene().getWindow();
        sta.close();
    }

    @FXML
    void reiniciar(ActionEvent event) {
        this.op = reiniciarBtn.getText();
        Stage sta = (Stage) this.reiniciarBtn.getScene().getWindow();
        sta.close();
    }


}
