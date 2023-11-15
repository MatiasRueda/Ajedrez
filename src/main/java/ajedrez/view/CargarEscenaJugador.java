package ajedrez.view;

import java.io.IOException;

import ajedrez.controller.Opciones;
import ajedrez.controller.OpcionesFinal;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CargarEscenaJugador {
    private String opcion;

    public void cargarOpciones(String color) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ajedrez/Escenarios/opciones.fxml"));
            Parent root = fxmlLoader.load();
            Opciones op = fxmlLoader.getController();
            op.setColor(color);
            op.agregarImagenes();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.showAndWait();

            this.opcion = op.getOpcionElegida();

            } catch (IOException e1) {
                e1.printStackTrace();
            }
    }


    public void cargarOpcionesFinal(String Jugador) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ajedrez/Escenarios/opcionesFinal.fxml"));
            Parent root = fxmlLoader.load();
            OpcionesFinal op = fxmlLoader.getController();
            op.setMensaje(Jugador);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.showAndWait();

            this.opcion = op.getOpFinal();

            } catch (IOException e1) {
                e1.printStackTrace();
            }
    }

    public String getOpcion() {
        return this.opcion;
    }
}
