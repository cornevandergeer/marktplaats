package nl.corne.marktplaats.model.util;

import jakarta.enterprise.inject.Alternative;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

@Singleton
@Alternative // CDI: neem deze class als hij als alternatief is geactiveerd in beans.xml
public class EntityManagerProducerAlt {

    @Produces
    public EntityManager em() {
        return Persistence
                .createEntityManagerFactory("H2-IT").createEntityManager();
    }
}
