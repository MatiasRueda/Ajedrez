package ajedrez.view;

import java.io.IOException;

import ajedrez.App.NumJugador;
import ajedrez.controller.Escenas;
import ajedrez.model.Juego;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class BotonesLogica {
    private Boolean eleccionRealizada = false;
    private Button botonElegido;
    private int columnaEleccion;
    private int filaEleccion;
    private int columnaCambiar;
    private int filaCambiar;
    
    private RegistroBotones registroBtn;
    private Juego juego;
    private RegistroGraficos registroInfo;

    private ImagenBoton imagenBtn = new ImagenBoton();
    private Musica musica = new Musica();
    private CargarEscenaJugador cargarEscenaJugador = new CargarEscenaJugador();
    private Escenas escenas = ajedrez.controller.Menu.escenas;

    public BotonesLogica(RegistroBotones registroBtn, Juego juego, RegistroGraficos registroInfo, GridPane panel) {
        this.registroBtn = registroBtn;
        this.juego = juego;
        this.registroInfo = registroInfo;
    }

/*  Metodo encargado de graficar la eleccion, coloreando aquellos botones a los que
 *  se podra mover.
 */
    private void eleccion(ActionEvent event, Button btn) {
        columnaEleccion = GridPane.getColumnIndex((Button)event.getSource());
        filaEleccion = GridPane.getRowIndex((Button)event.getSource());
        if (!this.juego.eleccionFicha(filaEleccion, columnaEleccion)) return;
        this.registroBtn.setPosicionesValidas(this.juego.getMovimientosPosibles());
        this.registroBtn.colorearPosiciones();
        this.eleccionRealizada = true;
        this.botonElegido = btn;
        return;
    }
    
/*  Metodo encargado de graficar como se realiza el intercambio de fichas luego de
 *  que se haya elegido una ficha anteriormente. Devuelve True en caso de que 
 *  el movimiento haya sido valido y False en caso contrario.
 */
    private Boolean elegirIntercambio(ActionEvent event, Button btn) {
        columnaCambiar = GridPane.getColumnIndex((Button)event.getSource());
        filaCambiar = GridPane.getRowIndex((Button)event.getSource());
        if (!this.juego.moverFicha(filaCambiar, columnaCambiar)){ 
            eleccionRealizada = false;
            musica.musicaErrorPlay();
            this.registroBtn.colorearPosicionesOriginales();
            return false;
         }

        this.registroInfo.verificarCapturas(this.juego.getTurnoUsuario());
        if (this.juego.getEnroque()) {
            graficoEnroque(btn);
            return true;
        }
        if (this.juego.getCambioPeon()){
            graficoCambioPeon(btn);
            return true;
        }
        if (juego.getJaque()) musica.musicaJaquePlay();
        btn.setGraphic(botonElegido.getGraphic());
        botonElegido.setGraphic(null);
        return true;
    }

/*  Metodo encargado de graficar como se realiza cambio de peon, se muestra
*   una escena con opciones de fichas y luego se agrega la imagen al peon
 */
    private void graficoCambioPeon(Button btn) {
        String color = (this.juego.getTurnoUsuario().getNumJugador() == NumJugador.UNO)? "blanco" : "negro";
        cargarEscenaJugador.cargarOpciones(color);
        String opcion = cargarEscenaJugador.getOpcion();
        this.juego.agregarFicha(opcion, filaCambiar, columnaCambiar);
        this.botonElegido.setGraphic(null);
        imagenBtn.colocarImagen(opcion, color, btn, 80);
    }


/*  Metodo creado exclusivamente para poder mostrar en pantalla como se aplica
 *  el enroque
 */
    private void graficoEnroque(Button btn) {
        int nuevaColumnaRey = (columnaEleccion == 0)? 2 : 6;
        int nuevaColumnaTorre = (nuevaColumnaRey == 2)? 3 : 5;
        Button nuevaTorre = registroBtn.getBtn(filaEleccion, nuevaColumnaTorre);
        Button nuevoRey = registroBtn.getBtn(filaCambiar, nuevaColumnaRey);
        nuevaTorre.setGraphic(this.botonElegido.getGraphic());
        nuevoRey.setGraphic(btn.getGraphic());
        btn.setGraphic(null);
        botonElegido.setGraphic(null);
    }

/*  Metodo que se encarga de mostrar como se avanza al  
 *  siguiente turno, verificando antes si el jugador gano
 */
    private void siguienteTurno() throws IOException {
        this.registroBtn.colorearPosicionesOriginales();
        if (this.juego.hayGanador()) {
            cargarSiguienteEscena();
        }
        this.juego.siguienteTurno();
        this.registroInfo.nuevoTurno(this.juego.getTurnoUsuario());
        eleccionRealizada = false;
        musica.musicaAceptadoPlay();
    }

/*  Metodo que muestra una escena con dos opciones, y se encarga de cargar una escena
 *  de acuerdo a la opcion elegida
 */
    private void cargarSiguienteEscena() throws IOException {
        String numeroJugador = this.juego.getTurnoUsuario().getNumJugador().toString();
        cargarEscenaJugador.cargarOpcionesFinal(numeroJugador);
        String opcion = cargarEscenaJugador.getOpcion();
        if (opcion.equals("Reiniciar")) {
            Musica.stopMusicaFondo();
            escenas.cambiarEscena("tablero");
            return;
        }
        Musica.stopMusicaFondo();
        musica.musicaIntroPlay();
        escenas.cambiarEscena("menu");
    }

/*  Se encarga de la logica de los botones, si la eleccion ya fue realizada entonces
 *  hay que elegir a que posicion moverse, en caso contrario se tendra  que elegir
 */
    private void logica(ActionEvent event, Button btn) throws IOException {
        if(eleccionRealizada) { 
            if (elegirIntercambio(event, btn)) siguienteTurno(); 
            return; 
        }
        eleccion(event, btn);
    }

    public void agregarLogicaAlBoton(Button btn) {
        btn.setOnAction((event) -> {
            try {
                logica(event, btn);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
