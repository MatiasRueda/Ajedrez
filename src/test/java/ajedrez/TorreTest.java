package ajedrez;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ajedrez.App.NumJugador;
import ajedrez.model.Tablero;
import ajedrez.model.tipoficha.Peon;
import ajedrez.model.tipoficha.Rey;
import ajedrez.model.tipoficha.Torre;

public class TorreTest {
    private Tablero tablero;
    private Torre torre;

    @Before
    public void preparativo() {
        this.tablero = new Tablero();
        this.tablero.llenarTablero();
        this.torre = new Torre("1", NumJugador.UNO);
    }

    @Test
    public void movimientosCorrectosTest(){
        tablero.colocarFicha(this.torre, 0, 0);
        assertTrue(this.torre.mover(0, 1, this.tablero));
        assertTrue(this.torre.mover(0, 0, this.tablero));
        assertTrue(this.torre.mover(0, 2, this.tablero));
        assertTrue(this.torre.mover(5, 2, this.tablero));
        assertTrue(this.torre.mover(5, 6, this.tablero));
        assertTrue(this.torre.mover(7, 6, this.tablero));
        assertTrue(this.torre.mover(7, 1, this.tablero));
        assertTrue(this.torre.mover(0, 1, this.tablero));
        assertTrue(this.torre.mover(0, 7, this.tablero));
    }

    @Test
    public void movimientosNoCorrectosTest(){
        tablero.colocarFicha(this.torre, 0, 0);
        assertFalse(this.torre.mover(1, 1, this.tablero));
        assertFalse(this.torre.mover(6, 6, this.tablero));
        assertFalse(this.torre.mover(5, 6, this.tablero));
        assertFalse(this.torre.mover(6, 4, this.tablero));
        assertFalse(this.torre.mover(3, 2, this.tablero));
        assertFalse(this.torre.mover(0, 0, this.tablero));
        assertFalse(this.torre.mover(2, 7, this.tablero));
    }

    @Test
    public void movimientosVariadosTest(){
        tablero.colocarFicha(this.torre, 0, 0);
        assertTrue(this.torre.mover(0, 1, this.tablero));
        assertFalse(this.torre.mover(1, 3, this.tablero));
        assertFalse(this.torre.mover(6, 6, this.tablero));
        assertTrue(this.torre.mover(0, 2, this.tablero));
        assertFalse(this.torre.mover(5, 6, this.tablero));
        assertTrue(this.torre.mover(5, 2, this.tablero));
        assertFalse(this.torre.mover(6, 4, this.tablero));
        assertFalse(this.torre.mover(3, 7, this.tablero));
        assertTrue(this.torre.mover(5, 7, this.tablero));
        assertFalse(this.torre.mover(0, 4, this.tablero));
        assertTrue(this.torre.mover(5, 0, this.tablero));
        assertTrue(this.torre.mover(0, 0, this.tablero));
    }


    @Test
    public void noSePuedePasarPorEncimaDeAliados(){
        var ficha2 = new Torre("2", NumJugador.UNO);
        this.tablero.colocarFicha(this.torre, 0, 0);
        this.tablero.colocarFicha(ficha2, 0, 1);
        assertFalse(this.torre.mover(0, 7, this.tablero));
    }

    @Test
    public void noSePuedeMoverAlMismoLugarDeUnAliado(){
        var ficha2 = new Torre("2", NumJugador.UNO);
        this.tablero.colocarFicha(this.torre, 0, 0);
        this.tablero.colocarFicha(ficha2, 0, 1);
        assertFalse(this.torre.mover(0, 1, this.tablero));
    }

    @Test
    public void noSePuedeQuedarEnElLugar(){
        this.torre = new Torre("1", NumJugador.UNO);
        this.tablero.colocarFicha(this.torre, 0, 0);
        assertFalse(this.torre.mover(0, 0, this.tablero));
    }

    @Test
    public void noSePuedePasarPorEncimaDeEnemigos(){
        var ficha2 = new Torre("2", NumJugador.DOS);
        this.tablero.colocarFicha(this.torre, 0, 0);
        this.tablero.colocarFicha(ficha2, 0, 1);
        assertFalse(this.torre.mover(0, 7, this.tablero));
    }

    @Test
    public void enreoqueIzquierdaTest(){
        var rey = new Rey("2", NumJugador.UNO);
        this.tablero.colocarFicha(this.torre, 0, 0);
        this.tablero.colocarFicha(rey, 0, 4);
        assertTrue(this.torre.mover(0, 4, this.tablero));
        var ubicacionTorre = this.tablero.ubicacionActualFicha(this.torre);
        var ubicacionRey = this.tablero.ubicacionActualFicha(rey);
        int torreFila = ubicacionTorre.get(0);
        int torreColumna = ubicacionTorre.get(1);
        int reyFila = ubicacionRey.get(0); 
        int reyColumna = ubicacionRey.get(1);
        assertEquals( 0, torreFila);
        assertEquals( 0, reyFila);
        assertEquals( 3, torreColumna);
        assertEquals( 2, reyColumna);
    }

    @Test
    public void enreoqueDerechaTest(){
        var rey = new Rey("2", NumJugador.UNO);
        this.tablero.colocarFicha(this.torre, 0, 7);
        this.tablero.colocarFicha(rey, 0, 4);
        assertTrue(this.torre.mover(0, 4, this.tablero));
        var ubicacionTorre = this.tablero.ubicacionActualFicha(this.torre);
        var ubicacionRey = this.tablero.ubicacionActualFicha(rey);
        int torreFila = ubicacionTorre.get(0);
        int torreColumna = ubicacionTorre.get(1);
        int reyFila = ubicacionRey.get(0); 
        int reyColumna = ubicacionRey.get(1);
        assertEquals( 0, torreFila);
        assertEquals( 0, reyFila);
        assertEquals( 5, torreColumna);
        assertEquals( 6, reyColumna);
    }

    @Test
    public void noSePuedeEnroqueTest(){
        var rey = new Rey("2", NumJugador.UNO);
        var peon = new Peon("3", NumJugador.UNO);
        this.tablero.colocarFicha(this.torre, 0, 0);
        this.tablero.colocarFicha(rey, 0, 4);
        this.tablero.colocarFicha(peon, 0, 3);
        assertFalse(this.torre.mover(0, 4, this.tablero));
    }


    @Test
    public void noSePuedeEnroqueSiNoEsPrimerMovimientoTest(){
        var rey = new Rey("2", NumJugador.UNO);
        this.tablero.colocarFicha(this.torre, 0, 0);
        this.tablero.colocarFicha(rey, 0, 4);
        assertTrue(this.torre.mover(0, 1, this.tablero));
        assertTrue(this.torre.mover(0, 0, this.tablero));
        assertFalse(this.torre.mover(0, 4, this.tablero));
    }
}
