package ajedrez;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ajedrez.App.NumJugador;
import ajedrez.model.Tablero;
import ajedrez.model.sucriber.RegistroFichas;
import ajedrez.model.tipoficha.Peon;



public class PeonTest {
    private Tablero tablero;
    private Peon peon1;
    private Peon peon2;
    private Peon peon3;

    @Before
    public void preparativo() {
        this.tablero = new Tablero();
        this.tablero.llenarTablero();
        this.peon1 = new Peon("1", NumJugador.UNO);
        this.peon2 = new Peon("2", NumJugador.DOS);   
        this.peon3 = new Peon("3", NumJugador.DOS);
    }

    @Test
    public void fichaInvocadaCorrectamenteTest(){
        var ficha = new Peon("1", NumJugador.UNO);
        assertFalse(ficha.mover(0, 0, this.tablero));
        tablero.colocarFicha(ficha, 0, 0);
        assertFalse(ficha.mover(0, 1, this.tablero));
        assertTrue(ficha.mover(2, 0, this.tablero));
        assertFalse(ficha.mover(4, 0, this.tablero));
        assertTrue(ficha.mover(3, 0, this.tablero));
        assertTrue(ficha.mover(4, 0, this.tablero));
        assertFalse(ficha.mover(6, 0, this.tablero));

        var ubicacion = tablero.ubicacionActualFicha(ficha);
        int filaActual = ubicacion.get(0);
        int columnaActual = ubicacion.get(1);


        assertEquals(4, filaActual);
        assertEquals(0, columnaActual);
    }

    @Test
    public void noSeMueveDeFormaOblicuaTest(){
        tablero.colocarFicha(this.peon1, 0, 0);
        assertFalse(this.peon1.mover(1, 1, tablero));
    }

    @Test
    public void noSePuedeCapturarHaciaAdelante(){
        tablero.colocarFicha(this.peon1, 0, 0);
        tablero.colocarFicha(this.peon2, 1, 0);
        assertFalse(this.peon1.mover(1, 0, this.tablero));
    }

    @Test
    public void SePuedeCapturarHaciaLosCostados(){
        tablero.colocarFicha(this.peon1, 0, 1);
        this.peon1.addsuscriber(new RegistroFichas());
        tablero.colocarFicha(this.peon2, 1, 0);
        tablero.colocarFicha(this.peon3, 2, 1);
        assertTrue(this.peon1.mover(1, 0, this.tablero));
        assertTrue(this.peon1.mover(2, 1, this.tablero));
    }
}
