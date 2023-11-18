package ajedrez.controller;

public enum MUSICA_CONTROL {
    PAUSAR("Pausar"), PLAY("Play");
    private String texto;

    MUSICA_CONTROL(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return this.texto;
    }
}
