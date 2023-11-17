package ajedrez.view;

import javafx.scene.control.Button;

public class BotonTablero {
    private final int WIDTH_HEIGHT_BOTON = 100;
    private final int TAMANIO_IMAGEN = 80;
    private final String estilo = "-fx-border-width: 1; -fx-border-color: black;"; 
    private final Imagen imagen = new Imagen();

/*  Metodo que se encarga de darle un color al boton dependiendo de casillero que se encuentre
 *  Crea al boton, le agrega un color de vuelve al boton.
 */

    public Button crear(String nombreDeLaFicha, String color, Boolean casillero) {
        Button boton = new Button();
        boton.setMinHeight(WIDTH_HEIGHT_BOTON);
        boton.setMinWidth(WIDTH_HEIGHT_BOTON);
        String colorCasillero = (casillero)? "white" : "green";
        boton.setId(colorCasillero);
        boton.setStyle("-fx-background-color: "+ colorCasillero + ";" + estilo);
        if (nombreDeLaFicha.equals("")) 
            return boton;
        imagen.colocarImagen(nombreDeLaFicha, color, boton, TAMANIO_IMAGEN);
        return boton;
    }
}

