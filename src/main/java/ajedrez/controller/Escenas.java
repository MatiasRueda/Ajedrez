package ajedrez.controller;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ajedrez.App;

public class Escenas {
    private Stage primaryStage;

    public FXMLLoader getFXML(ESCENA fxml) {
        return new FXMLLoader(App.class.getResource("/ajedrez/Escenarios/"+ fxml.toString().toLowerCase() + ".fxml"));
    }

    public Parent loadFXML(ESCENA fxml) throws IOException {
        FXMLLoader fxmlLoader = this.getFXML(fxml);
        return fxmlLoader.load();
    }

    public void setStage(Stage stage) {
        this.primaryStage = stage;
    }

    public void mostrarStage(Parent root) {
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public Stage cambiarEscena(ESCENA escena) throws IOException{
        Parent root = loadFXML(escena);
        Scene nuevaEscena = new Scene(root);
        this.primaryStage.setScene(nuevaEscena);
        return this.primaryStage;
    }

}