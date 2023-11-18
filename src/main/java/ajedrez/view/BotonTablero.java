package ajedrez.view;

import javafx.scene.control.Button;

public class BotonTablero {
    private final int WIDTH_HEIGHT_BOTON = 100;
    private final int TAMANIO_IMAGEN = 80;
    private final String borde = "-fx-border-width: 1; -fx-border-color: black; -fx-background-insets: 0;"; 
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
        if (nombreDeLaFicha.equals("")) {
            boton.setStyle("-fx-background-color: "+ colorCasillero + ";" + "-fx-cursor: DEFAULT; " + borde);
            return boton;
        }
        boton.setStyle("-fx-background-color: "+ colorCasillero + ";" + "-fx-cursor: HAND; " + borde);
        imagen.colocarImagen(nombreDeLaFicha, color, boton, TAMANIO_IMAGEN);
        return boton;
    }

    public void actualizarEstilos(Button btnElegido, Button btnMover) {
        btnMover.setGraphic(btnElegido.getGraphic());
        btnMover.setStyle("-fx-background-color: " + btnMover.getId() + "; " + "-fx-cursor: HAND; " + borde );
        btnElegido.setGraphic(null);
        btnElegido.setStyle("-fx-background-color: " + btnElegido.getId() + "; " + "-fx-cursor: DEFAULT; " + borde );
    }

    public void colorOriginal(Button boton) {
        String estiloAnterior = boton.getStyle();
        boton.setStyle(estiloAnterior + "-fx-background-color: " + boton.getId() + "; " + borde);
    }

    public void colorPosiblePosicion(Button boton) {
        String estiloAnterior = boton.getStyle();
        boton.setStyle(estiloAnterior + "-fx-background-color: red;" + borde);
    }
}

