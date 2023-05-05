package nl.corne.marktplaats.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class GebruikerDao {

    private EntityManagerFactory mySQL = Persistence.createEntityManagerFactory("MySQL");
    private EntityManager em = mySQL.createEntityManager();

    public void insert(Gebruiker gebruiker) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(gebruiker);
        transaction.commit();
    }

    public void setGebruikerToAdmin(long id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Gebruiker gebruiker = em.createQuery("select g from Gebruiker g where id=" + id, Gebruiker.class).getSingleResult();
        System.out.println(gebruiker);
//        gebruiker.setRol(Rol.BEHEERDER);
        transaction.commit();
    }

}
