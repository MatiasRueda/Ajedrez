package ajedrez.model;

import ajedrez.model.publisher.Ficha;
import ajedrez.model.tipoficha.Afil;
import ajedrez.model.tipoficha.Caballo;
import ajedrez.model.tipoficha.Peon;
import ajedrez.model.tipoficha.Reina;
import ajedrez.model.tipoficha.Rey;
import ajedrez.model.tipoficha.Torre;

public class FabricaDeFichas {
    public Ficha getFicha(String nombreDeFicha, String id, JUGADOR jugador) {
        if (nombreDeFicha.equals("Peon")) 
            return new Peon(id, jugador);
        else if (nombreDeFicha.equals("Torre")) 
            return new Torre(id, jugador);
        else if (nombreDeFicha.equals("Afil"))
            return new Afil(id, jugador);
        else if (nombreDeFicha.equals("Reina"))
            return new Reina(id, jugador);
        else if (nombreDeFicha.equals("Rey"))
            return new Rey(id, jugador);
        else
            return new Caballo(id, jugador);
    }
}
