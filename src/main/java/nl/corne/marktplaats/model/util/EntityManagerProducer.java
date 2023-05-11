package nl.corne.marktplaats.model.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerProducer {
    public final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MySQL");

}
