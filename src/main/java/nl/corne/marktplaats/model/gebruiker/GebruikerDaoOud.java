package nl.corne.marktplaats.model.gebruiker;

import jakarta.persistence.*;


public class GebruikerDaoOud {

    private EntityManagerFactory mySQL = Persistence.createEntityManagerFactory("MySQL");
    private EntityManager em = mySQL.createEntityManager();


    public GebruikerOud selectGebruiker(String voornaam) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        String query = "select g from GebruikerOud g where voornaam = :n";
        GebruikerOud gebruikerOud = em.createQuery(query, GebruikerOud.class).
                setParameter("n", voornaam).
                getSingleResult();
        transaction.commit();
        return gebruikerOud;
    }

    public void create(GebruikerOud gebruikerOud) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(gebruikerOud);
        transaction.commit();
    }

    public GebruikerOud inlogGebruiker(String email, String wachtwoord) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        String query = "select g from GebruikerOud g where email = :e and wachtwoord = :ww";
        try {
            GebruikerOud gebruikerOud = em.createQuery(query, GebruikerOud.class).
                    setParameter("e", email).
                    setParameter("ww", wachtwoord).
                    getSingleResult();
            gebruikerOud.setIngelogd(true);
            transaction.commit();
            return gebruikerOud;
        } catch (NoResultException e){
            transaction.rollback();
            return null;
        }
    }

    // TO DO: log gebruiker uit


}
