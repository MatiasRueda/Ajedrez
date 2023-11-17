package ajedrez;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import ajedrez.controller.ESCENA;
import ajedrez.controller.Menu;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Ajedrez");
        stage.setResizable(false);
        Menu.escenas.setStage(stage);
        Stage menu = Menu.escenas.cambiarEscena(ESCENA.MENU);
        menu.show();
    }

    public static void main(String[] args) {
        launch();
    }

}