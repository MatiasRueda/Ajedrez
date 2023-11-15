package ajedrez.model;

import ajedrez.App.NumJugador;
import ajedrez.model.publisher.Ficha;
import ajedrez.model.tipoficha.Afil;
import ajedrez.model.tipoficha.Caballo;
import ajedrez.model.tipoficha.Peon;
import ajedrez.model.tipoficha.Reina;
import ajedrez.model.tipoficha.Rey;
import ajedrez.model.tipoficha.Torre;

public class FabricaDeFichas {
    public Ficha getFicha(String nombreDeFicha, String id, NumJugador numJugador) {
        if (nombreDeFicha.equals("Peon")) {
            return new Peon(id, numJugador);
        }
        else if (nombreDeFicha.equals("Torre")) {
            return new Torre(id, numJugador);
        }
        else if (nombreDeFicha.equals("Afil")) {
            return new Afil(id, numJugador);
        }
        else if (nombreDeFicha.equals("Reina")) {
            return new Reina(id, numJugador);
        }
        else if (nombreDeFicha.equals("Rey")) {
            return new Rey(id, numJugador);
        }
        else {
            return new Caballo(id, numJugador);
        }
    }
}
