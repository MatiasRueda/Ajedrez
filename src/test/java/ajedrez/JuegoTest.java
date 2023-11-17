package ajedrez;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ajedrez.model.JUGADOR;
import ajedrez.model.Ajedrez;

public class JuegoTest {
    private Ajedrez juego;

    @Before
    public void preparativo() {;
        this.juego = new Ajedrez();
    }

    @Test
    public void comienzoJuegoTest(){
        assertEquals(JUGADOR.UNO, this.juego.getTurnoUsuario().getJugador());
    }

    @Test
    public void movimientosCorrectosFichasTest(){
        assertTrue(this.juego.eleccionFicha(1, 1));
        assertTrue(this.juego.moverFicha(3, 1));
        this.juego.siguienteTurno();
        assertTrue(this.juego.eleccionFicha(6, 1));
        assertTrue(this.juego.moverFicha(4, 1));
        this.juego.siguienteTurno();
        assertTrue(this.juego.eleccionFicha(1, 0));
        assertTrue(this.juego.moverFicha(3, 0));
        this.juego.siguienteTurno();
        assertTrue(this.juego.eleccionFicha(6, 6));
        assertTrue(this.juego.moverFicha(4, 6));
    }


    @Test
    public void movimientosNoCorrectosFichasTest(){
        assertFalse(this.juego.eleccionFicha(4, 0));
        assertFalse(this.juego.moverFicha(0, 1));

        assertFalse(this.juego.eleccionFicha(5, 5));
        assertFalse(this.juego.moverFicha(4, 1));

        assertFalse(this.juego.eleccionFicha(2, 0));
        assertFalse(this.juego.moverFicha(4, 0));

        assertFalse(this.juego.eleccionFicha(5, 6));
        assertFalse(this.juego.moverFicha(4, 6));
    }

    
    @Test
    public void noSePuedeMoverSinElegirFichaTest(){
        assertFalse(this.juego.moverFicha(0, 1));
        assertFalse(this.juego.moverFicha(4, 1));

        assertTrue(this.juego.eleccionFicha(1, 0));
        assertTrue(this.juego.moverFicha(3, 0));
    }

    @Test
    public void seRespetanLosTurnosTest(){
        assertEquals(JUGADOR.UNO, this.juego.getTurnoUsuario().getJugador());
        assertTrue(this.juego.eleccionFicha(1, 1));
        assertTrue(this.juego.moverFicha(3, 1));
        this.juego.siguienteTurno();
        assertEquals(JUGADOR.DOS, this.juego.getTurnoUsuario().getJugador());
        assertTrue(this.juego.eleccionFicha(6, 6));
        assertTrue(this.juego.moverFicha(4, 6));
        this.juego.siguienteTurno();
        assertEquals(JUGADOR.UNO, this.juego.getTurnoUsuario().getJugador());
    }
    
    @Test
    public void movimientoInvalidoNoPasaTurnoTest(){
        assertEquals(JUGADOR.UNO, this.juego.getTurnoUsuario().getJugador());
        assertFalse(this.juego.eleccionFicha(4, 1));
        assertFalse(this.juego.moverFicha(3, 1));

        assertNotEquals(JUGADOR.DOS, this.juego.getTurnoUsuario().getJugador());
        assertEquals(JUGADOR.UNO, this.juego.getTurnoUsuario().getJugador());

    }
    
}
