package ajedrez.view;

import java.net.URL;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/* Las imagenes de las fichas fueron extraidas de la siguiente pagina
  https://es.wikipedia.org/wiki/Ajedrez */

public class Imagen {
    // Se coloca la imagen sobre el boton pasado por parametro.
    public void colocarImagen(String nombre,  String color, Button btnIcono, int tamanio) {
        URL linkImagen = getClass().getResource("/ajedrez/Imagenes/" + nombre + "_" + color + ".png");
        Image nuevaImagen = new Image(linkImagen.toString(), tamanio, tamanio, false, true);
        btnIcono.setGraphic((new ImageView(nuevaImagen)));
    }

}
