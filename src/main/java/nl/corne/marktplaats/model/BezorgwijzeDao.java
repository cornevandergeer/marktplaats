package nl.corne.marktplaats.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BezorgwijzeDao {

    private EntityManagerFactory mySQL = Persistence.createEntityManagerFactory("MySQL");
    private EntityManager em = mySQL.createEntityManager();

    public void create(Bezorgwijze bezorgwijze) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(bezorgwijze);
        transaction.commit();
    }

    public Bezorgwijze update(Bezorgwijze bezorgwijze) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Bezorgwijze merged = em.merge(bezorgwijze);
        transaction.commit();
        return merged;
    }

}
