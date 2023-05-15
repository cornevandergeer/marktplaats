package nl.corne.marktplaats.model.it;

import jakarta.inject.Inject;
import nl.corne.marktplaats.model.gebruiker.Gebruiker;
import nl.corne.marktplaats.model.gebruiker.GebruikerDAO;
import nl.corne.marktplaats.model.util.EntityManagerProducerAlt;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.EnableAlternatives;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableAutoWeld // make this test CDI-enabled
@AddBeanClasses({EntityManagerProducerAlt.class, Gebruiker.class}) // beans.xml
@EnableAlternatives(EntityManagerProducerAlt.class)
public class MarktplaatsIT {

    @Inject
    private GebruikerDAO target;

    @BeforeEach
    void setUp() {
        // target
    }

    @Test
    void whenInsertValidGebruikerThenItIsInsertedInTheDatabase() {
        // given
        Gebruiker corne = Gebruiker.builder().username("corne").wachtwoord("12345").voornaam("corne").achternaam("van der geer").woonplaats("apeldoorn").favorieteProgrammeertaal("java").build();

        // when
        target.insert(corne);

        // then
        Gebruiker select = target.get("corne");
        assertNotNull(select);

    }


}
