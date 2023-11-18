package ajedrez;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import ajedrez.controller.ESCENA;
import ajedrez.controller.Intro;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Ajedrez");
        stage.setResizable(false);
        Intro.escenas.setStage(stage);
        Stage menu = Intro.escenas.cambiarEscena(ESCENA.INTRO);
        menu.show();
    }

    public static void main(String[] args) {
        launch();
    }

}