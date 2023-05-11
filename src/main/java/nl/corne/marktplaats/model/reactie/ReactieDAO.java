package nl.corne.marktplaats.model.reactie;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;
import nl.corne.marktplaats.model.advertentie.Advertentie;
import nl.corne.marktplaats.model.util.EntityManagerProducer;

import java.util.List;

@Slf4j
@Singleton
public class ReactieDAO implements ReactieDAOInterface{

    private final EntityManager em = EntityManagerProducer.emf.createEntityManager();

    @Override
    public List<Reactie> getAll() {
        return null;
    }

    public List<Reactie> getAllReactiesOfAdvertentie(Advertentie advertentie) {
        return em.createNamedQuery("Reactie.findAll", Reactie.class).
                setParameter("advID", advertentie).getResultList();

    }

    @Override
    public void insert(Reactie reactie) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.persist(reactie);
            transaction.commit();
        } catch(Exception e){
            log.error("Er ging iets mis: ", e);
            transaction.rollback();
        }
    }

    @Override
    public int update(Reactie reactie) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.merge(reactie);
            transaction.commit();
            return 1;
        } catch (Exception e) {
            log.error("Er ging iets mis: ", e);
            transaction.rollback();
            return 0;
        }
    }

    @Override
    public int delete(Reactie reactie) {
        return 0;
    }


}
