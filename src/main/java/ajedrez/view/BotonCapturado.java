package ajedrez.view;

import javafx.scene.control.Button;

public class BotonCapturado {
    private final int WIDTH_HEIGHT_BOTON = 50;
    private final int TAMANIO_IMAGEN = 40;
    private final String estilo = "-fx-background-color: white; -fx-border-width: 1; -fx-border-color: black; -fx-background-insets: 0;";
    private final Imagen imagen = new Imagen();

    public Button crear(String nombreImagen, String color) {
        Button boton = new Button();
        boton.setPrefWidth(WIDTH_HEIGHT_BOTON);
        boton.setPrefHeight(WIDTH_HEIGHT_BOTON);
        boton.setStyle(estilo);
        imagen.colocarImagen(nombreImagen, color, boton, TAMANIO_IMAGEN);
        return boton;
    }
}
