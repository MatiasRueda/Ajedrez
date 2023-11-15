package ajedrez;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

import ajedrez.controller.Menu;
import ajedrez.view.Musica;

public class App extends Application {
    public enum NumJugador {UNO, DOS};
    private static Musica musica = new Musica();

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Ajedrez");
        stage.setResizable(false);
        Menu.escenas.setStage(stage);
        Stage menu = Menu.escenas.cambiarEscena("menu");
        menu.show();
        musica.musicaIntroPlay();
    }

    public static void main(String[] args) {
        launch();
    }

}