package nl.corne.marktplaats.model.gebruiker;

import org.junit.jupiter.api.Test;

import static nl.corne.marktplaats.model.gebruiker.Bezorgwijze.THUISAFHALEN;
import static org.junit.jupiter.api.Assertions.*;

class BezorgwijzeTest {

    @Test
    void name() {
        Bezorgwijze thuisafhalen = THUISAFHALEN;
        thuisafhalen.getDescription();
        thuisafhalen.toString();


    }
}