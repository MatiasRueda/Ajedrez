package ajedrez.controller;

import ajedrez.model.JUGADOR;
import ajedrez.model.Usuario;
import javafx.scene.layout.TilePane;

public class Registros {
    private Registro jugadorUNO;
    private Registro jugadorDOS;

    public Registros(TilePane panelUNO, TilePane panelDOS) {
        this.jugadorUNO = new Registro(panelUNO);
        this.jugadorDOS = new Registro(panelDOS);
    }

    public boolean verificarCapturas(Usuario usuario) {
        return usuario.getJugador() == JUGADOR.UNO? 
            this.jugadorUNO.verificarCapturas(usuario) : this.jugadorDOS.verificarCapturas(usuario);
    }
    
}
