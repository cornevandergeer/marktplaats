package nl.corne.marktplaats.model.gebruiker;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Dependent
public class GebruikerDAO implements GebruikerDAOInterface {

    // PersistenceContext
    @Inject
    private EntityManager em;

    @Override
    public Gebruiker get(int id){
        return em.find(Gebruiker.class, id);
    }

    @Override
    public List<Gebruiker> getAll(){
        return null;
    }

    @Override
    public int save(Gebruiker gebruiker){
        return 0;
    }

    @Override
    public void insert(Gebruiker gebruiker) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(gebruiker);
            transaction.commit();
        } catch(Exception e){
            log.error("Er ging iets mis:", e);
            transaction.rollback();
        }
    }

    @Override
    public int update(Gebruiker gebruiker){
        return 0;
    }

    @Override
    public int delete(Gebruiker gebruiker){
        return 0;
    }

    public Gebruiker inlogGebruiker(String username, String wachtwoord) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        String query = "select g from Gebruiker g where username = :u and wachtwoord = :ww";
        try {
            Gebruiker gebruiker = em.createQuery(query, Gebruiker.class).
                    setParameter("u", username).
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

    public void close(){
        em.close();
    }
}
