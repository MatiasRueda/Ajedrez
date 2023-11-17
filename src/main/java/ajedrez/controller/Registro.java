package ajedrez.controller;

import ajedrez.model.JUGADOR;
import ajedrez.model.Usuario;
import ajedrez.view.BotonCapturado;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

public class Registro {
    private TilePane registro;
    private BotonCapturado botonCapturado = new BotonCapturado();
    private int longitud = 0;

    public Registro(TilePane registro) {
        this.registro = registro;
    }

    public boolean verificarCapturas(Usuario usuario) {
        String color = (usuario.getJugador() == JUGADOR.UNO)? "negro" : "blanco";
        if(usuario.cantidadCapturas() == longitud) 
            return false;
        Button capturado = botonCapturado.crear(usuario.getUltimaCaptura().getNombre(), color);
        registro.getChildren().add(capturado);
        longitud++;
        return true;
    }
}
