package ajedrez.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CargarEscena {
    
    //  Metodo encargado de cambiar de una escena a otra, desde "escenaActual" hacia "siguienteEscena"
    public void cargarSiguienteScena(Pane escenaActual, String siguienteEscena){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ajedrez/Escenarios/"+ siguienteEscena +".fxml"));
            Parent root = fxmlLoader.load();
            Scene scena = new Scene(root);
            Stage stage = (Stage)escenaActual.getScene().getWindow();
            stage.setScene(scena);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
    }
}
