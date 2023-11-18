package ajedrez.model;

import java.util.ArrayList;
import java.util.HashMap;

import ajedrez.model.publisher.Ficha;
import ajedrez.model.sucriber.Suscriber;

public class Ajedrez {
    private Tablero tablero = new Tablero();
    private TurnoUsuario turnoUsuario;
    private Ficha fichaMover;
    private Ficha fichaElegida;
    private int enroqueRey = 0;
    private int enroqueTorre = 0;
    private Boolean movimientoEnroque = false;
    private Boolean cambioPeon = false;
    private Boolean jaque = false;    
    private HashMap<Integer, ArrayList<Integer>> movimientosPosibles;
    private ControladorJaque controladorJaque;

    public Ajedrez() {
        this.tablero.llenarTablero();
        this.controladorJaque = new ControladorJaque(this.tablero);
        this.turnoUsuario = new TurnoUsuario(this.tablero);
    }

    private void enroque(ArrayList<Integer> posicion) {
        this.enroqueRey = posicion.get(1) == 0? 2 : 6;
        this.enroqueTorre = (this.enroqueRey == 2)? 3 : 5;
        this.movimientoEnroque = true;
    }

    public Boolean eleccionFicha(int fila, int columna) {
        this.cambioPeon = false;
        this.movimientoEnroque = false;
        Ficha fichaElegida = this.tablero.getFicha(fila, columna);
        if (!this.turnoUsuario.fichaDelUsuario(fichaElegida)) 
            return false;
        this.fichaMover = fichaElegida;
        this.movimientosPosibles = fichaElegida.movPosibles(this.tablero);
        if (!fichaElegida.mismoTipo(FICHA.REY)) 
            return true;
        Usuario rival = this.turnoUsuario.getRival();
        controladorJaque.setMovPosibles(this.movimientosPosibles);
        this.movimientosPosibles = controladorJaque.posibleJaque(rival, fichaElegida);
        this.fichaMover.setMovimientos(this.movimientosPosibles);
        return true; 
    }

    public HashMap<Integer, ArrayList<Integer>> getMovimientosPosibles() {
        return this.movimientosPosibles;
    }

    public Boolean moverFicha(int fila, int columna) {
        if (this.fichaMover == null) 
            return false;
        var posicionAnterior = this.tablero.ubicacionActualFicha(fichaMover);
        this.fichaElegida = this.tablero.getFicha(fila, columna);
        if (!this.turnoUsuario.getTurnoActual().moverFicha(fila, columna, this.fichaMover)) 
            return false;
        if (this.fichaElegida != null && 
            this.fichaMover.mismoTipo(FICHA.TORRE) && 
            this.fichaElegida.mismoTipo(FICHA.REY) && 
            this.fichaMover.getJugador() == this.fichaElegida.getJugador())
                enroque(posicionAnterior);
        if (this.fichaMover.mismoTipo(FICHA.PEON) && fila == this.fichaMover.getUltimaFila())
            this.cambioPeon = true;
        Usuario jugando = this.turnoUsuario.getTurnoActual();
        Usuario rival = this.turnoUsuario.getRival(); 
        if (jugando.getUltimaCaptura() != null ) rival.sacarFicha(jugando.getUltimaCaptura());
        this.jaque = jugando.buscandoJaque();
        this.fichaMover = null;
        this.fichaElegida = null;
        return true;
    }

    public int getNuevaColumnaTorre() {
        return this.enroqueTorre;
    }

    public int getNuevaColumnaRey() {
        return this.enroqueRey;
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

    public void agregarFicha(FICHA tipoFicha, int fila, int columna) {
        Ficha ficha = tablero.getFicha(fila, columna);
        Suscriber registro = ficha.getSuscriber();
        FabricaDeFichas fabrica = new FabricaDeFichas();
        Ficha fichaCreada = fabrica.getFicha(tipoFicha, ficha.getId(), ficha.getJugador());
        fichaCreada.addsuscriber(registro);
        this.turnoUsuario.getTurnoActual().agregarFichaAlasDisponibles(fichaCreada);
        this.tablero.sacarFicha(ficha);
        this.tablero.colocarFicha(fichaCreada, fila, columna);
    }
}
