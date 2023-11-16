package ajedrez.model;
import ajedrez.model.publisher.Ficha;

public class TurnoUsuario {
    private Usuario usuario1;
    private Usuario usuario2;
    private Usuario turnoActual;

    public TurnoUsuario(Tablero tablero) {
        this.usuario1 = new Usuario(JUGADOR.UNO, tablero);
        this.usuario2 = new Usuario(JUGADOR.DOS, tablero);
        this.turnoActual = this.usuario1;
    }

    public Usuario getTurnoActual() {
        return this.turnoActual;
    }

    public Usuario getRival() {
        return (this.turnoActual.getJugador() == JUGADOR.UNO)? this.usuario2 : this.usuario1;
    }

    public Boolean fichaDelUsuario(Ficha ficha) {
        if(ficha == null) return false;
        if(ficha.getJugador() != this.turnoActual.getJugador()) return false;
        return true;
    }

    public void siguienteTurno() {
        this.turnoActual = (this.turnoActual.getJugador() == this.usuario1.getJugador())? this.usuario2 : this.usuario1;
    }
}
