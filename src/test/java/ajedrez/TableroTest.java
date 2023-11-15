package ajedrez;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ajedrez.App.NumJugador;
import ajedrez.model.Tablero;
import ajedrez.model.tipoficha.Torre;

public class TableroTest {
    private Tablero tablero;
    private final int CANT_FILAS = 8;
    private final int CANT_COLUMNAS = 8;

    @Before
    public void armarTablero() {
        this.tablero = new Tablero();
        this.tablero.llenarTablero();
    }


    @Test
    public void posicionFueraDelTableroTest() {
        assertTrue(this.tablero.posicionFueraDelTablero(10, 7));
        assertTrue(this.tablero.posicionFueraDelTablero(10, 0));
        assertTrue(this.tablero.posicionFueraDelTablero(-1, 8));
        assertTrue(this.tablero.posicionFueraDelTablero(30, 4));
        assertTrue(this.tablero.posicionFueraDelTablero(8, 8));
        assertTrue(this.tablero.posicionFueraDelTablero(0, -1));

        assertFalse(this.tablero.posicionFueraDelTablero(0, 0));
        assertFalse(this.tablero.posicionFueraDelTablero(3, 1));
        assertFalse(this.tablero.posicionFueraDelTablero(5, 6));
        assertFalse(this.tablero.posicionFueraDelTablero(7,7));

    }

    @Test
    public void sePuedeColocarEnTodasLasPosicionesTest() {
        for (int i = 0; i < CANT_FILAS; i++) {
            var ficha = new Torre("1", NumJugador.UNO);
            for (int j = 0; j < CANT_COLUMNAS; j++) {
                assertFalse(this.tablero.posicionOcupada(i, j));
                assertNull(this.tablero.colocarFicha(ficha, i, j));
                assertTrue(this.tablero.posicionOcupada(i, j));
            }
        }
    }

    @Test
    public void sePuedeObtenerCasillaCorrectamenteTest() {
        for (int i = 0; i < CANT_FILAS; i++) {
            for (int j = 0; j < CANT_COLUMNAS; j++) {
                assertNotNull(this.tablero.getCasilla(i, j));
            }
        }
        assertNull(this.tablero.getCasilla(8, 0));
        assertNull(this.tablero.getCasilla(-1, 0));
        assertNull(this.tablero.getCasilla(0, 10));
        assertNull(this.tablero.getCasilla(0, -30));
    }

    @Test
    public void sePuedeObtenerFichaTest() {
        var ficha = new Torre("1",NumJugador.UNO);
        assertNull(this.tablero.colocarFicha(ficha, 0, 0));
        assertNotNull(this.tablero.getFicha(0, 0));
        var fichaElegida = this.tablero.getFicha(0, 0);
        assertEquals("1", fichaElegida.getId());
    }

    @Test
    public void colocarFichaTest() {
        assertNull(this.tablero.getFicha(0, 0));
        var ficha = new Torre("1",NumJugador.UNO);
        assertNull(this.tablero.colocarFicha(ficha, 0, 0));
        assertTrue(this.tablero.estaLaFicha(ficha));
    }
    
    @Test
    public void sacarFichaTest() {
        var ficha = new Torre("1",NumJugador.UNO);
        assertFalse(this.tablero.sacarFicha(ficha));
        assertNull(this.tablero.colocarFicha(ficha, 0, 0));
        assertTrue(this.tablero.estaLaFicha(ficha));
        assertTrue(this.tablero.sacarFicha(ficha));
        assertFalse(this.tablero.estaLaFicha(ficha));
    }

    @Test
    public void saberUbicacionDeFicha() {
        var ficha = new Torre("1",NumJugador.UNO);
        assertNull(this.tablero.colocarFicha(ficha, 0, 0));
        assertNotNull(this.tablero.ubicacionActualFicha(ficha));
        var ubicacion = this.tablero.ubicacionActualFicha(ficha);
        int fila = ubicacion.get(0);
        int columna = ubicacion.get(1);
        assertEquals(0, fila);
        assertEquals(0, columna);

        ficha.mover(0, 7, this.tablero);
        ficha.mover(5, 7, this.tablero);
        assertNotNull(this.tablero.ubicacionActualFicha(ficha));
        ubicacion = this.tablero.ubicacionActualFicha(ficha);
        fila = ubicacion.get(0);
        columna = ubicacion.get(1);
        assertEquals(5, fila);
        assertEquals(7, columna);
    }


    @Test
    public void NoSePuedeSaberUbicacionDeFicha() {
        var ficha = new Torre("1",NumJugador.UNO);
        assertNull(this.tablero.ubicacionActualFicha(ficha));
        var ficha2 = new Torre("3",NumJugador.DOS);
        assertNull(this.tablero.ubicacionActualFicha(ficha2));
    }

}
