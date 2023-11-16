package ajedrez.model;

import ajedrez.model.publisher.Ficha;
import ajedrez.model.tipoficha.Afil;
import ajedrez.model.tipoficha.Caballo;
import ajedrez.model.tipoficha.Peon;
import ajedrez.model.tipoficha.Reina;
import ajedrez.model.tipoficha.Rey;
import ajedrez.model.tipoficha.Torre;

public class FabricaDeFichas {
    public Ficha getFicha(FICHA ficha, String id, JUGADOR jugador) {
        if (ficha == FICHA.PEON) 
            return new Peon(id, jugador);
        else if (ficha == FICHA.TORRE) 
            return new Torre(id, jugador);
        else if (ficha == FICHA.AFIL)
            return new Afil(id, jugador);
        else if (ficha == FICHA.REINA)
            return new Reina(id, jugador);
        else if (ficha == FICHA.REY)
            return new Rey(id, jugador);
        else
            return new Caballo(id, jugador);
    }
}
