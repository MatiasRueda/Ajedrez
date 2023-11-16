package ajedrez;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ajedrez.model.JUGADOR;
import ajedrez.model.Tablero;
import ajedrez.model.sucriber.RegistroFichas;
import ajedrez.model.tipoficha.Caballo;


public class CaballoTest {
    private Tablero tablero;
    private Caballo caballo;
    

    @Before
    public void llamarFichasTest() {
        this.tablero = new Tablero();
        this.tablero.llenarTablero();
        this.caballo = new Caballo("1", JUGADOR.UNO);
    }

    @Test
    public void correctosMovimientosCaballoTest(){
        assertFalse(this.caballo.mover(0, 0, this.tablero));
        tablero.colocarFicha(this.caballo, 2, 1);
        assertTrue(this.caballo.mover(3, 3, this.tablero));
        assertTrue(this.caballo.mover(5, 2, this.tablero));
    }


    @Test
    public void sePuedeCapturarCorrectamenteTest(){
        Caballo caballoRival = new Caballo("2", JUGADOR.DOS);
        RegistroFichas registro = new RegistroFichas();
        this.caballo.addsuscriber(registro);
        tablero.colocarFicha(this.caballo, 2, 1);
        tablero.colocarFicha(caballoRival, 3, 3);
        assertTrue(this.caballo.mover(3, 3, this.tablero));
        int numeroCapturas = registro.numeroDeCapturas();
        assertEquals(1, numeroCapturas);
    }

}
