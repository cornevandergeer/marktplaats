package nl.corne.marktplaats.model.advertentie;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;
import nl.corne.marktplaats.model.gebruiker.Gebruiker;
import nl.corne.marktplaats.model.reactie.Reactie;
import nl.corne.marktplaats.model.util.EntityManagerProducer;

import java.util.List;

@Slf4j
@Singleton
public class AdvertentieDAO implements AdvertentieDAOInterface {

    private final EntityManager em = EntityManagerProducer.emf.createEntityManager();

    @Override
    public Advertentie get(int id) {
        return em.find(Advertentie.class, id);
    }

    @Override
    public List<Advertentie> getAllAdvertentieFromGebruiker(Gebruiker gebruiker) {
        return em.createNamedQuery("Advertentie.findAllSameGebruiker", Advertentie.class).
                setParameter("gebruiker", gebruiker).getResultList();
    }

    public List<Advertentie> getAllBeschikbareAdvertenties() {
        return em.createNamedQuery("Advertentie.findAllBeschikbaar", Advertentie.class).
                setParameter("status", StatusAdvertentie.BESCHIKBAAR).getResultList();
    }

    @Override
    public List<Advertentie> getAll() {
        return em.createNamedQuery("Advertentie.findAll", Advertentie.class).
                getResultList();
    }

    @Override
    public void insert(Advertentie advertentie) {
        EntityTransaction transaction = em.getTransaction();
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
        EntityTransaction transaction = em.getTransaction();
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
