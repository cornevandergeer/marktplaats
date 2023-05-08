package nl.corne.marktplaats.model;

import jakarta.persistence.*;


public class GebruikerDao {

    private EntityManagerFactory mySQL = Persistence.createEntityManagerFactory("MySQL");
    private EntityManager em = mySQL.createEntityManager();


    public Gebruiker selectGebruiker(String voornaam) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        String query = "select g from Gebruiker g where voornaam = :n";
        Gebruiker gebruiker = em.createQuery(query, Gebruiker.class).
                setParameter("n", voornaam).
                getSingleResult();
        transaction.commit();
        return gebruiker;
    }

    public void create(Gebruiker gebruiker) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(gebruiker);
        transaction.commit();
    }

    public Gebruiker inlogGebruiker(String email, String wachtwoord) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        String query = "select g from Gebruiker g where email = :e and wachtwoord = :ww";
        try {
            Gebruiker gebruiker = em.createQuery(query, Gebruiker.class).
                    setParameter("e", email).
                    setParameter("ww", wachtwoord).
                    getSingleResult();
            gebruiker.setIngelogd(true);
            transaction.commit();
            return gebruiker;
        } catch (NoResultException e){
            transaction.rollback();
            return null;
        }
    }

    // TO DO: log gebruiker uit


}
