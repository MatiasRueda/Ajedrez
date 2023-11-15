package ajedrez.model;

import ajedrez.App.NumJugador;
import ajedrez.model.publisher.Ficha;

public class TurnoUsuario {
    private Usuario usuario1;
    private Usuario usuario2;
    private Usuario turnoActual;

    public TurnoUsuario(Tablero tablero) {
        this.usuario1 = new Usuario(NumJugador.UNO, tablero);
        this.usuario2 = new Usuario(NumJugador.DOS, tablero);
        this.turnoActual = this.usuario1;
    }

    public Usuario getTurnoActual() {
        return this.turnoActual;
    }

    public Usuario getRival() {
        return (this.turnoActual.getNumJugador() == NumJugador.UNO)? this.usuario2 : this.usuario1;
    }

    public Boolean fichaDelUsuario(Ficha ficha) {
        if(ficha == null) return false;
        if(ficha.getNumJugador() != this.turnoActual.getNumJugador()) return false;
        return true;
    }

    public void siguienteTurno() {
        this.turnoActual = (this.turnoActual.getNumJugador() == this.usuario1.getNumJugador())? this.usuario2 : this.usuario1;
    }
}
