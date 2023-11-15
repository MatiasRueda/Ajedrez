package ajedrez;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import ajedrez.view.Musica;

public class App extends Application {
    public enum NumJugador {UNO, DOS};
    private static Musica musica = new Musica();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ajedrez/Escenarios/menu.fxml"));
        Parent root  = fxmlLoader.load();
        Scene scene  = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Ajedrez");
        stage.setResizable(false);
        stage.show();
        musica.musicaIntroPlay();
    }

    public static void main(String[] args) {
        launch();
    }

}