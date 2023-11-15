package ajedrez;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ajedrez.App.NumJugador;
import ajedrez.model.Tablero;
import ajedrez.model.tipoficha.Reina;


public class ReinaTest {
    private Tablero tablero;

    @Before
    public void llamarFichasTest() {
        this.tablero = new Tablero();
        this.tablero.llenarTablero();
    }

    @Test
    public void correctosMovimientosReinaTest(){
        var ficha = new Reina("1", NumJugador.UNO);
        assertEquals("Reina", ficha.getNombre());
        assertFalse(ficha.mover(0, 0, this.tablero));
        this.tablero.colocarFicha(ficha, 0, 0);
        assertTrue(ficha.mover(7, 0, this.tablero));
        assertTrue(ficha.mover(7, 7, this.tablero));
        assertTrue(ficha.mover(0, 0, this.tablero));
    }
}
