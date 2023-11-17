package ajedrez.view;

import ajedrez.model.JUGADOR;
import ajedrez.model.Usuario;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.TilePane;

public class Paneles {
    private TilePane panelUNO;
    private TilePane panelDOS;
    private Label turno;
    private Imagen imagenBtn = new Imagen();
    private int longitudUNO = 0;
    private int longitudDOS = 0;
    private final int WIDTH_HEIGHT_BOTON = 50;
    private final int TAMANIO_IMAGEN = 40;

    public Paneles(TilePane panelUNO, TilePane panelDOS, Label turno) {
        this.panelUNO = panelUNO;
        this.panelDOS = panelDOS;
        this.turno = turno;
    }

    public void nuevoTurno(Usuario usuario) {
        this.turno.setText("Es el turno jugador: " + usuario.getJugador().toString());
    }

    public void  verificarCapturas(Usuario usuario) {
        var tilePane = (usuario.getJugador() == JUGADOR.UNO)? panelUNO : panelDOS;
        int longitud = (usuario.getJugador() == JUGADOR.UNO)? longitudUNO: longitudDOS;
        String color = (usuario.getJugador() == JUGADOR.UNO)? "negro" : "blanco";
        if(usuario.cantidadCapturas() == longitud) return;
        var btn = new Button();
        btn.setMinHeight(WIDTH_HEIGHT_BOTON);
        btn.setMaxHeight(WIDTH_HEIGHT_BOTON);
        btn.setMinWidth(WIDTH_HEIGHT_BOTON);
        btn.setMaxWidth(WIDTH_HEIGHT_BOTON);
        imagenBtn.colocarImagen(usuario.getUltimaCaptura().getNombre(), color, btn, TAMANIO_IMAGEN);
        tilePane.getChildren().add(btn);
        if (usuario.getJugador() == JUGADOR.UNO) {
            longitudUNO++;
            return;
        }
        longitudDOS++;
    }
    
}
