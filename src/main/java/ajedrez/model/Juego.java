package ajedrez.model;

import java.util.ArrayList;
import java.util.HashMap;

import ajedrez.model.publisher.Ficha;
import ajedrez.model.sucriber.Suscriber;

public class Juego {
    private Tablero tablero = new Tablero();
    private TurnoUsuario turnoUsuario;
    private Ficha fichaMover;
    private Ficha fichaElegida;
    private Boolean movimientoEnroque = false;
    private Boolean cambioPeon = false;
    private Boolean jaque = false;    
    private HashMap<Integer, ArrayList<Integer>> movimientosPosibles;
    private ControladorJaque controladorJaque;

    public Juego() {
        this.tablero.llenarTablero();
        this.controladorJaque = new ControladorJaque(this.tablero);
        this.turnoUsuario = new TurnoUsuario(this.tablero);
    }


    public Boolean eleccionFicha(int fila, int columna) {
        this.cambioPeon = false;
        this.movimientoEnroque = false;
        var fichaSeleccionada = this.tablero.getFicha(fila, columna);
        if (!this.turnoUsuario.fichaDelUsuario(fichaSeleccionada)) return false;
        this.fichaMover = fichaSeleccionada;
        this.movimientosPosibles = fichaSeleccionada.verificarMovimientosPosibles(this.tablero);
        if (!fichaSeleccionada.getNombre().equals("Rey")) return true;
        Usuario rival = this.turnoUsuario.getRival();
        controladorJaque.setMovimientosPosibles(this.movimientosPosibles);
        this.movimientosPosibles = controladorJaque.posibleJaque(rival, fichaSeleccionada);
        this.fichaMover.setMovimientos(this.movimientosPosibles);
        return true; 
    }


    public HashMap<Integer, ArrayList<Integer>> getMovimientosPosibles() {
        return this.movimientosPosibles;
    }

    public Boolean moverFicha(int fila, int columna) {
        if (this.fichaMover == null) return false;
        this.fichaElegida = this.tablero.getFicha(fila, columna);
        if (!this.turnoUsuario.getTurnoActual().moverFicha(fila, columna, this.fichaMover)) return false;

        if (this.fichaElegida != null && this.fichaMover.getNombre().equals("Torre") && this.fichaElegida.getNombre().equals("Rey")) {
            if (this.fichaMover.getJugador() == this.fichaElegida.getJugador()) this.movimientoEnroque = true;
        }
        if (this.fichaMover.getNombre().equals("Peon") && fila == this.fichaMover.getFILA_FINAL()) {
            this.cambioPeon = true;
        }
        var jugando = this.turnoUsuario.getTurnoActual();
        var rival = this.turnoUsuario.getRival(); 
        if (jugando.getUltimaCaptura() != null ) rival.sacarFicha(jugando.getUltimaCaptura());
        this.jaque = jugando.buscandoJaque();
        this.fichaMover = null;
        this.fichaElegida = null;
        return true;
    }

    public Boolean getJaque() {
        return this.jaque;
    }

    public Boolean getCambioPeon() {
        return this.cambioPeon;
    }

    public Boolean getEnroque() {
        return this.movimientoEnroque;
    }

    public void siguienteTurno() {
        this.turnoUsuario.siguienteTurno();
    }

    public Usuario getTurnoUsuario() {
        return this.turnoUsuario.getTurnoActual();
    }

    public Usuario getUsuarioRival() {
        return this.turnoUsuario.getRival();
    }

    public Boolean hayGanador() {
        return this.turnoUsuario.getTurnoActual().gano() || getUsuarioRival().noHayMovimientosPosibles(getTurnoUsuario(), controladorJaque);
    }

    public ArrayList<ArrayList<String>> getTablero() {
        return this.tablero.getNombresFichasTablero();
    }

    public void agregarFicha(String nombreFicha, int fila, int columna) {
        Ficha ficha = tablero.getFicha(fila, columna);
        Suscriber registro = ficha.getSuscriber();
        FabricaDeFichas fabrica = new FabricaDeFichas();
        Ficha fichaCreada = fabrica.getFicha(nombreFicha, ficha.getId(), ficha.getJugador());
        fichaCreada.addsuscriber(registro);
        this.turnoUsuario.getTurnoActual().agregarFichaAlasDisponibles(fichaCreada);
        this.tablero.sacarFicha(ficha);
        this.tablero.colocarFicha(fichaCreada, fila, columna);
    }
}
