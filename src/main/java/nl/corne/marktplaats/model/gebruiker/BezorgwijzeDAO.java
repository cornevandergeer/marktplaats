package nl.corne.marktplaats.model.gebruiker;

public class BezorgwijzeDAO {

    public void addBezorgwijze(String opgegevenBezorgwijze, Bezorgwijze bezorgwijze, Gebruiker gebruiker) {
        if (opgegevenBezorgwijze.equals(bezorgwijze.name())) {
            gebruiker.getBezorgwijzes().add(bezorgwijze);
        }
    }

}
