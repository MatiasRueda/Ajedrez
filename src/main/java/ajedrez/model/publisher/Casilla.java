package ajedrez.model.publisher;

public class Casilla {
    private Ficha ficha = null;

    public void setFicha(Ficha reemplazoDeFicha) {
        this.ficha = reemplazoDeFicha;
    }

    public Ficha getFicha() {
        return this.ficha;
    }

    public boolean estaVacia() {
        return (this.ficha == null)? true : false;
    }
}
