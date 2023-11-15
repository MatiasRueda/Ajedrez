package ajedrez;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ajedrez.App.NumJugador;
import ajedrez.model.Tablero;
import ajedrez.model.tipoficha.Afil;

public class AfilTest {
    private Tablero tablero;
    private Afil afil;

    @Before
    public void preparativo() {
        this.tablero = new Tablero();
        this.tablero.llenarTablero();
        this.afil = new Afil("1", NumJugador.UNO);
    }

    @Test
    public void movimientosCorrectosTest(){
        assertEquals("Afil", this.afil.getNombre());
        this.tablero.colocarFicha(this.afil, 0, 0);
        assertTrue(this.afil.mover(1, 1, this.tablero));
        assertTrue(this.afil.mover(0, 0, this.tablero));   
        assertTrue(this.afil.mover(5, 5, this.tablero)); 
        assertTrue(this.afil.mover(4, 6, this.tablero)); 
        assertTrue(this.afil.mover(5, 5, this.tablero)); 
        assertTrue(this.afil.mover(0, 0, this.tablero));
        assertTrue(this.afil.mover(7, 7, this.tablero));
    }

    @Test
    public void movimientosNoCorrectosTest(){
        assertEquals("Afil", this.afil.getNombre());
        this.tablero.colocarFicha(this.afil, 0, 0);
        assertFalse(this.afil.mover(1, 0, this.tablero));
        assertFalse(this.afil.mover(0, 6, this.tablero));
        assertFalse(this.afil.mover(4, 1, this.tablero));
        assertFalse(this.afil.mover(0, 0, this.tablero));
        assertFalse(this.afil.mover(5, 7, this.tablero));
    }


    @Test
    public void movimientosVariadosTest(){
        assertEquals("Afil", this.afil.getNombre());
        this.tablero.colocarFicha(this.afil, 0, 0);
        assertFalse(this.afil.mover(0, 0, this.tablero));
        assertFalse(this.afil.mover(1, 0, this.tablero));
        assertTrue(this.afil.mover(1, 1, this.tablero));
        assertFalse(this.afil.mover(0, 6, this.tablero));
        assertFalse(this.afil.mover(4, 1, this.tablero));
        assertTrue(this.afil.mover(5, 5, this.tablero));
        assertTrue(this.afil.mover(0, 0, this.tablero));
        assertFalse(this.afil.mover(5, 7, this.tablero));
        assertTrue(this.afil.mover(7, 7, this.tablero));
    }


    @Test
    public void noSePuedePasarPorEncimaDeAliados(){
        var ficha2 = new Afil("2", NumJugador.UNO);
        this.tablero.colocarFicha(this.afil, 0, 0);
        this.tablero.colocarFicha(ficha2, 1, 1);
        assertFalse(this.afil.mover(7, 7, this.tablero));
    }

    @Test
    public void noSePuedeMoverAlMismoLugarDeUnAliado(){
        var ficha2 = new Afil("2", NumJugador.UNO);
        this.tablero.colocarFicha(this.afil, 0, 0);
        this.tablero.colocarFicha(ficha2, 1, 1);
        assertFalse(this.afil.mover(1, 1, this.tablero));
    }

    @Test
    public void noSePuedeQuedarEnElLugar(){
        this.tablero.colocarFicha(this.afil, 0, 0);
        assertFalse(this.afil.mover(0, 0, this.tablero));
    }

    @Test
    public void noSePuedePasarPorEncimaDeEnemigos(){
        var ficha2 = new Afil("2", NumJugador.DOS);
        this.tablero.colocarFicha(this.afil, 0, 0);
        this.tablero.colocarFicha(ficha2, 1, 1);
        assertFalse(this.afil.mover(7, 7, this.tablero));
    }

}