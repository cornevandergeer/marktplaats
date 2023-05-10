package nl.corne.marktplaats.model.gebruiker;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

public class BezorgwijzeDAO {

    @Inject
    private EntityManager em;


    public void addBezorgwijze(String opgegevenBezorgwijze, Bezorgwijze bezorgwijze, Gebruiker gebruiker) {
        if (opgegevenBezorgwijze.equals(bezorgwijze.name())) {
            gebruiker.getBezorgwijzes().add(bezorgwijze);
            System.out.println(opgegevenBezorgwijze + " toegevoegd");
        }
    }

}
