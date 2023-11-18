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

    private final double VOLUMEN = 0;
    
    public void musicaIntroPlay() {
        media = new Media(getClass().getResource("/ajedrez/Musica/musica_generica.mp3").toString());
        musicaFondo = new MediaPlayer(media);
        musicaFondo.setVolume(VOLUMEN);
        Runnable onEnd = new Runnable() {
            @Override
            public void run() {
                musicaFondo.dispose();
                musicaFondo = new MediaPlayer(media);
                musicaFondo.setVolume(VOLUMEN);
                musicaFondo.play();
                musicaFondo.setOnEndOfMedia(this);
            }
        };
        musicaFondo.setOnEndOfMedia(onEnd);
        musicaFondo.play();
    }

    public void musicaJuegoPlay() {
        media = new Media(getClass().getResource("/ajedrez/Musica/musica_juego.mp3").toString());
        musicaFondo = new MediaPlayer(media);
        musicaFondo.setVolume(VOLUMEN);
        Runnable onEnd = new Runnable() {
            @Override
            public void run() {
                musicaFondo.dispose();
                musicaFondo = new MediaPlayer(media);
                musicaFondo.setVolume(VOLUMEN);
                musicaFondo.play();
                musicaFondo.setOnEndOfMedia(this);
            }
        };
        musicaFondo.setOnEndOfMedia(onEnd);
        musicaFondo.play();
    }


    public void musicaAceptadoPlay() {
        media2 = new Media(getClass().getResource("/ajedrez/Musica/aceptado.mp3").toString());
        efectoSonido = new MediaPlayer(media2);
        efectoSonido.setVolume(VOLUMEN);
        efectoSonido.play();
    }


    public void musicaErrorPlay() {
        media2 = new Media(getClass().getResource("/ajedrez/Musica/error.mp3").toString());
        efectoSonido = new MediaPlayer(media2);
        efectoSonido.setVolume(VOLUMEN);
        efectoSonido.play();
    }

    public void musicaJaquePlay() {
        media2 = new Media(getClass().getResource("/ajedrez/Musica/jaque.mp3").toString());
        efectoSonido = new MediaPlayer(media2);
        efectoSonido.setVolume(VOLUMEN);
        efectoSonido.play();
    }

    public static void stopMusicaFondo() {
        if (musicaFondo == null) return;
        musicaFondo.stop();
    }

}
