package nl.corne.marktplaats.model.bod;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;
import nl.corne.marktplaats.model.advertentie.Advertentie;
import nl.corne.marktplaats.model.util.EntityManagerProducer;

import java.util.List;

@Slf4j
@Singleton
public class BodDAO implements BodDAOInterface{

    private final EntityManager em = EntityManagerProducer.emf.createEntityManager();

    @Override
    public Bod get(Advertentie advertentie) {
        return em.find(Bod.class, advertentie);
    }

    @Override
    public List<Bod> getAll() {
        return null;
    }

    public boolean checkIfBodIsPresentForAdvertentie(Advertentie advertentie){
        List<Bod> checklist = em.createNamedQuery("Bod.findBodAdvertentie", Bod.class).
                setParameter("advertentie", advertentie).
                getResultList();
        return checklist.size() != 0;
    }

    @Override
    public void insert(Bod bod) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.persist(bod);
            transaction.commit();
        } catch(Exception e){
            log.error("Er ging iets mis: ", e);
            transaction.rollback();
        }
    }

    @Override
    public int update(Bod bod) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.merge(bod);
            transaction.commit();
            return 1;
        } catch (Exception e){
            log.error("Er ging iets mis: ", e);
            transaction.rollback();
            return 0;
        }
    }

    @Override
    public int delete(Bod bod) {
        return 0;
    }

}
