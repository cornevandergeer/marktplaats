package nl.corne.marktplaats.model.bod;

import nl.corne.marktplaats.model.DAOInterface;
import nl.corne.marktplaats.model.advertentie.Advertentie;

public interface BodDAOInterface extends DAOInterface<Bod> {
    Bod get(Advertentie advertentie);
}
