package ajedrez.controller;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/* Efectos de sonido:
 * sonido error descargado de Pixabay (negative beeps)
 * sonido acertado descargado de Pixabay (beep)
 * sonido jaque descargado de Pixabay (beep beep) 
 * 
 * Musica del juego realizada por EvgenyBardyuzha descargada de Pixabay (Beyond the Mask)
 * 
 * Pagina pixabay https://pixabay.com
 */

public class Musica {
    public static MediaPlayer musicaFondo;
    private Media media = null;

    public static MediaPlayer efectoSonido;
    private Media media2 = null;

    private double volumenMusica = 0.05;
    private double volumenEfecto = 0.05;
    
    public void musicaFondoPlay(MUSICA_FONDO musica) {
        if (musicaFondo != null)
            musicaFondo.stop();
        media = new Media(getClass().getResource("/ajedrez/Musica/"+ musica.toString().toLowerCase() +".mp3").toString());
        musicaFondo = new MediaPlayer(media);
        musicaFondo.setVolume(volumenMusica);
        Runnable onEnd = new Runnable() {
            @Override
            public void run() {
                musicaFondo.dispose();
                musicaFondo = new MediaPlayer(media);
                musicaFondo.setVolume(volumenMusica);
                musicaFondo.play();
                musicaFondo.setOnEndOfMedia(this);
            }
        };
        musicaFondo.setOnEndOfMedia(onEnd);
        musicaFondo.play();
    }

    public void sonidoPlay(SONIDO sonido) {
        media2 = new Media(getClass().getResource("/ajedrez/Musica/"+ sonido.toString().toLowerCase() +".mp3").toString());
        efectoSonido = new MediaPlayer(media2);
        efectoSonido.setVolume(volumenEfecto);
        efectoSonido.play();
    }

    public void pausarMusicaFondo() {
        musicaFondo.stop();
    }

    public double getMusica() {
        return this.volumenMusica * 1000;
    }

    public void setMusica(double volumen) {
        this.volumenMusica = volumen/1000;
        this.musicaFondoPlay(MUSICA_FONDO.INTRO);
    }

    public double getEfecto() {
        return this.volumenEfecto * 1000;
    }

    public void setEfecto(double volumen) {
        this.volumenEfecto = volumen/1000;
    }
}
