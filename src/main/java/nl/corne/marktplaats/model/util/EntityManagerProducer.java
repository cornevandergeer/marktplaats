package nl.corne.marktplaats.model.util;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerProducer {
    public final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MySQL");

}
