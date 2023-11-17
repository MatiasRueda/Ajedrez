package ajedrez.view;

import ajedrez.model.JUGADOR;
import ajedrez.model.Usuario;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

public class Registro {
    private TilePane registro;
    private Imagen imagenBtn = new Imagen();
    private int longitud = 0;
    private final int WIDTH_HEIGHT_BOTON = 50;
    private final int TAMANIO_IMAGEN = 40;

    public Registro(TilePane registro) {
        this.registro = registro;
    }

    public boolean verificarCapturas(Usuario usuario) {
        String color = (usuario.getJugador() == JUGADOR.UNO)? "negro" : "blanco";
        if(usuario.cantidadCapturas() == longitud) 
            return false;
        Button boton = new Button();
        boton.setMinHeight(WIDTH_HEIGHT_BOTON);
        boton.setMaxHeight(WIDTH_HEIGHT_BOTON);
        boton.setMinWidth(WIDTH_HEIGHT_BOTON);
        boton.setMaxWidth(WIDTH_HEIGHT_BOTON);
        imagenBtn.colocarImagen(usuario.getUltimaCaptura().getNombre(), color, boton, TAMANIO_IMAGEN);
        registro.getChildren().add(boton);
        longitud++;
        return true;
    }
}
