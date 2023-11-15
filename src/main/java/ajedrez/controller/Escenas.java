package ajedrez.controller;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ajedrez.App;

public class Escenas {
    private Stage primaryStage;

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    public FXMLLoader getFXML(String fxml) {
        return new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    }

    public Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = this.getFXML(fxml);
        return fxmlLoader.load();
    }

    public Stage mostrarEscenaSig(String siguienteEscena) throws IOException{
        Parent root = loadFXML(siguienteEscena);
        Scene escena = new Scene(root);
        this.primaryStage.setScene(escena);
        return this.primaryStage;
    }

}