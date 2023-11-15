package ajedrez.controller;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ajedrez.App;

public class Escenas {
    private Stage primaryStage;

    private FXMLLoader getFXML(String fxml) {
        return new FXMLLoader(App.class.getResource("/ajedrez/Escenarios/"+ fxml + ".fxml"));
    }

    private Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = this.getFXML(fxml);
        return fxmlLoader.load();
    }

    public void setStage(Stage stage) {
        this.primaryStage = stage;
    }

    public Stage cambiarEscena(String escena) throws IOException{
        Parent root = loadFXML(escena);
        Scene nuevaEscena = new Scene(root);
        this.primaryStage.setScene(nuevaEscena);
        return this.primaryStage;
    }

}