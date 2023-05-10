package nl.corne.marktplaats.model.gebruiker;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class BezorgwijzeDAO {

    @Inject
    private EntityManager em;


    public void addBezorgwijze(String opgegevenBezorgwijze, Bezorgwijze bezorgwijze, Gebruiker gebruiker) {
        if (opgegevenBezorgwijze.equals(bezorgwijze.name())) {
            gebruiker.getBezorgwijzes().add(bezorgwijze);
            System.out.println(opgegevenBezorgwijze + " toegevoegd");
        }
    }
    public void insertBezorgwijzes(Gebruiker gebruiker) {
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();

        ;
        System.out.println(gebruiker.getBezorgwijzes().toArray().length);
        for (int i = 0; i < gebruiker.getBezorgwijzes().size(); i++) {

        }
//        em.persist(gebruiker.getBezorgwijzes());
//        transaction.commit();
    }
}
