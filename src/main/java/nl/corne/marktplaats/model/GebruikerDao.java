package nl.corne.marktplaats.model;

import jakarta.persistence.*;

public class GebruikerDao {

    private EntityManagerFactory mySQL = Persistence.createEntityManagerFactory("MySQL");
    private EntityManager em = mySQL.createEntityManager();

    public void insert(Gebruiker gebruiker) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(gebruiker);
        transaction.commit();
    }

    public void inlogGebruiker(String gebruikersnaam, String wachtwoord) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Gebruiker gebruiker = em.createQuery(
                "select g from Gebruiker g " +
                "where gebruikersNaam='" + gebruikersnaam +"'" +
                "and wachtwoord='" + wachtwoord +"'",
                Gebruiker.class).getSingleResult();
        gebruiker.setIngelogd(true);
        System.out.println("logged in:");
        System.out.println(gebruiker);
        transaction.commit();
    }

}
