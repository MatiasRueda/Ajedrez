package ajedrez;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ajedrez.App.NumJugador;
import ajedrez.model.Tablero;
import ajedrez.model.tipoficha.Rey;


public class ReyTest {
    private Tablero tablero;
    private Rey Rey;

    @Before
    public void preparativo() {
        this.tablero = new Tablero();
        this.tablero.llenarTablero();
        this.Rey = new Rey("1", NumJugador.UNO);
    }

    @Test
    public void movimientosCorrectosTest(){
        this.tablero.colocarFicha(this.Rey, 0, 0);
        this.Rey.setMovimientos(this.Rey.verificarMovimientosPosibles(this.tablero));
        assertTrue(this.Rey.mover(1, 0, this.tablero));
        this.Rey.setMovimientos(this.Rey.verificarMovimientosPosibles(this.tablero));
        assertTrue(this.Rey.mover(1, 1, this.tablero));
        this.Rey.setMovimientos(this.Rey.verificarMovimientosPosibles(this.tablero));
        assertTrue(this.Rey.mover(2, 0, this.tablero));
    }

    @Test
    public void movimientosNoCorrectosTest(){
        this.tablero.colocarFicha(this.Rey, 0, 0);
        this.Rey.setMovimientos(this.Rey.verificarMovimientosPosibles(this.tablero));
        assertFalse(this.Rey.mover(1, 7, this.tablero));
        assertFalse(this.Rey.mover(0, 8, this.tablero));
        assertFalse(this.Rey.mover(1, 5, this.tablero));
        assertFalse(this.Rey.mover(2, 0, this.tablero));
    }

    @Test
    public void noSePuedeMoverAlMismoLugarDeUnAliado(){
        var Rey2 = new Rey("2", NumJugador.UNO);
        this.tablero.colocarFicha(this.Rey, 0, 0);
        this.tablero.colocarFicha(Rey2, 0, 1);
        this.Rey.setMovimientos(this.Rey.verificarMovimientosPosibles(this.tablero));
        assertFalse(this.Rey.mover(0, 1, this.tablero));
    }

    @Test
    public void noSePuedeQuedarEnElLugar(){
        this.tablero.colocarFicha(this.Rey, 0, 0);
        this.Rey.setMovimientos(this.Rey.verificarMovimientosPosibles(this.tablero));
        assertFalse(this.Rey.mover(0, 0, this.tablero));
    }

}
