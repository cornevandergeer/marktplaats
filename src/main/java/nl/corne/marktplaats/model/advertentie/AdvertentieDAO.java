package nl.corne.marktplaats.model.advertentie;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Singleton
public class AdvertentieDAO implements AdvertentieDAOInterface {

    @Inject
    private EntityManager em;
    EntityTransaction transaction = em.getTransaction();

    @Override
    public Advertentie get(int id) {
        return em.find(Advertentie.class, id);
    }

    @Override
    public List<Advertentie> getAll() {
        return em.createNamedQuery("Advertentie.findAll", Advertentie.class).getResultList();
    }

    @Override
    public int save(Advertentie advertentie) {
        return 0;
    }

    @Override
    public void insert(Advertentie advertentie) {
        transaction.begin();
        try {
            em.persist(advertentie);
            transaction.commit();
        } catch(Exception e){
            log.error("Er ging iets mis: ", e);
            transaction.rollback();
        }
    }

    @Override
    public int update(Advertentie advertentie) {
        transaction.begin();
        try {
            em.merge(advertentie);
            transaction.commit();
            return 1;
        } catch (Exception e){
            log.error("Er ging iets mis: ", e);
            transaction.rollback();
            return 0;
        }
    }

    @Override
    public int delete(Advertentie advertentie) {
        return 0;
    }
}
