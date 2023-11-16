package ajedrez;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ajedrez.model.JUGADOR;
import ajedrez.model.Tablero;
import ajedrez.model.publisher.Ficha;
import ajedrez.model.sucriber.RegistroFichas;
import ajedrez.model.tipoficha.Rey;
import ajedrez.model.tipoficha.Torre;


public class RegistroFichasTest {
    private Tablero tablero;
    private Ficha ficha;
    private Ficha ficha2;
    private RegistroFichas registro;
    private RegistroFichas registro2;

    @Before
    public void preparativo() {
        this.tablero = new Tablero();
        this.tablero.llenarTablero();

        this.ficha = new Torre("1", JUGADOR.UNO);
        this.registro = new RegistroFichas();
        this.ficha.addsuscriber(registro);

        this.ficha2 = new Torre("2", JUGADOR.DOS);
        this.registro2 = new RegistroFichas();
        this.ficha2.addsuscriber(registro2);
    }

    @Test
    public void fichasPuedenCapturar() {
        var ficha3 = new Torre("3", JUGADOR.DOS);
        ficha3.addsuscriber(registro2);
        tablero.colocarFicha(this.ficha, 0, 0);
        tablero.colocarFicha(this.ficha2, 0, 1);
        tablero.colocarFicha(ficha3, 0, 2);
        this.ficha.mover(0, 1, this.tablero);
        int cantidad = this.registro.numeroDeCapturas();
        assertEquals(1, cantidad);
        this.ficha.mover(0, 2, this.tablero);
        cantidad = this.registro.numeroDeCapturas();
        assertEquals(2, cantidad);
    }

    @Test
    public void fichasNoPuedenCapturar() {
        var ficha3 = new Torre("3", JUGADOR.UNO);
        ficha3.addsuscriber(registro);
        tablero.colocarFicha(this.ficha, 0, 0);
        tablero.colocarFicha(ficha3, 0, 1);
        this.ficha.mover(0, 1, this.tablero);
        int cantidad = this.registro.numeroDeCapturas();
        assertEquals(0, cantidad);
    }

    @Test
    public void registroCapturaDelRey() {
        var ficha3 = new Rey("3", JUGADOR.DOS);
        ficha3.addsuscriber(this.registro2);

        this.tablero.colocarFicha(this.ficha, 0, 0);
        this.tablero.colocarFicha(this.ficha2, 0, 5);
        this.tablero.colocarFicha(ficha3, 0, 7);

        assertFalse(registro.reyCapturado());

        this.ficha.mover(0, 5, this.tablero);
        assertFalse(registro.reyCapturado());

        this.ficha.mover(0, 7, this.tablero);
        assertTrue(registro.reyCapturado());
    }
    
}
