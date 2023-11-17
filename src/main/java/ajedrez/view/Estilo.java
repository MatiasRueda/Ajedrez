package ajedrez.view;

import javafx.scene.control.Button;

public class Estilo {
    private Imagen imagenBtn = new Imagen();
    private final int WIDTH_HEIGHT_BOTON = 100;
    private final int TAMANIO_IMAGEN = 80;

/*  Metodo que se encarga de darle un color al boton dependiendo de casillero que se encuentre
 *  Crea al boton, le agrega un color de vuelve al boton.
 */

    public Button crearBotonPersonalizado(String nombreDeLaFicha, String color, Boolean casillero) {
        Button btn = new Button();
        personalizarBoton(btn, nombreDeLaFicha, color, casillero);
        return btn;
    }

    private void personalizarBoton(Button btn, String nombreDeLaFicha, String color, Boolean casillero) {
        btn.setMinHeight(WIDTH_HEIGHT_BOTON);
        btn.setMinWidth(WIDTH_HEIGHT_BOTON);
        String colorCasillero = (casillero)? "white" : "green";
        btn.setStyle("-fx-background-color: "+ colorCasillero);
        if (nombreDeLaFicha.equals("")) 
            return;
        imagenBtn.colocarImagen(nombreDeLaFicha, color, btn, TAMANIO_IMAGEN);
    }


}

