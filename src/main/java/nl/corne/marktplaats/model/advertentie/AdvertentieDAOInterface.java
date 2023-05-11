package nl.corne.marktplaats.model.advertentie;

import nl.corne.marktplaats.model.DAOInterface;
import nl.corne.marktplaats.model.gebruiker.Gebruiker;

import java.util.List;

public interface AdvertentieDAOInterface extends DAOInterface<Advertentie> {
    Advertentie get(int id);

    List<Advertentie> getAllAdvertentieFromGebruiker(Gebruiker gebruiker);
}
