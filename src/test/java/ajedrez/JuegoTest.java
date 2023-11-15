package ajedrez;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ajedrez.App.NumJugador;
import ajedrez.model.Juego;

public class JuegoTest {
    private Juego juego;

    @Before
    public void preparativo() {;
        this.juego = new Juego();
    }

    @Test
    public void comienzoJuegoTest(){
        assertEquals( NumJugador.UNO, this.juego.getTurnoUsuario().getNumJugador());
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
        assertEquals( NumJugador.UNO, this.juego.getTurnoUsuario().getNumJugador());
        assertTrue(this.juego.eleccionFicha(1, 1));
        assertTrue(this.juego.moverFicha(3, 1));
        this.juego.siguienteTurno();
        assertEquals( NumJugador.DOS, this.juego.getTurnoUsuario().getNumJugador());
        assertTrue(this.juego.eleccionFicha(6, 6));
        assertTrue(this.juego.moverFicha(4, 6));
        this.juego.siguienteTurno();
        assertEquals( NumJugador.UNO, this.juego.getTurnoUsuario().getNumJugador());
    }
    
    @Test
    public void movimientoInvalidoNoPasaTurnoTest(){
        assertEquals( NumJugador.UNO, this.juego.getTurnoUsuario().getNumJugador());
        assertFalse(this.juego.eleccionFicha(4, 1));
        assertFalse(this.juego.moverFicha(3, 1));

        assertNotEquals( NumJugador.DOS, this.juego.getTurnoUsuario().getNumJugador());
        assertEquals( NumJugador.UNO, this.juego.getTurnoUsuario().getNumJugador());

    }
    
}
