package ajedrez.model.sucriber;

import java.util.HashMap;

import ajedrez.model.publisher.Ficha;


public class RegistroFichas implements Suscriber {
    private HashMap<String, Ficha> capturadas = new HashMap<>();
    private boolean reyCapturado = false;
    private Ficha ultimaCaptura;

    public void update(Ficha ficha) {
        capturadas.put(ficha.getId(), ficha);
        this.ultimaCaptura = ficha;
        this.reyCapturado = (ficha.getNombre().equals("Rey"));
    }

    public Ficha getUltimaCaptura() {
        return this.ultimaCaptura;
    }

    public int numeroDeCapturas(){
        return this.capturadas.size();
    }
    
    public HashMap<String, Ficha> getCapturadas() {
        return this.capturadas;
    }

    public boolean reyCapturado() {
        return this.reyCapturado;
    }
}