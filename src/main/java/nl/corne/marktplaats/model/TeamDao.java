package nl.corne.marktplaats.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TeamDao {

    private EntityManagerFactory mySQL = Persistence.createEntityManagerFactory("MySQL");
    private EntityManager em = mySQL.createEntityManager();
    public void delete(Team team) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(team);
        transaction.commit();
    }
}
