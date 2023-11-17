package ajedrez.controller;

import ajedrez.model.Usuario;
import javafx.scene.control.Label;

public class Turno {
    private Label turno;

    public Turno(Label turno) {
        this.turno = turno;
    }

    public void nuevoTurno(Usuario usuario) {
        this.turno.setText("Es el turno jugador: " + usuario.getJugador().toString());
    }

}
