package nl.corne.marktplaats.view;

import nl.corne.marktplaats.model.gebruiker.Gebruiker;

public class GebruikerOutputView {

    public void gebruikerGegevens(Gebruiker gebruiker) {
        System.out.println("Uw gegevens zijn:");
        System.out.println("- UserID:      " + gebruiker.getUserID());
        System.out.println("- Username:    " + gebruiker.getUsername());
        System.out.println("- Rol:         " + gebruiker.getRol());
        System.out.println("- Voornaam:    " + gebruiker.getVoornaam());
        System.out.println("- Achternaam:  " + gebruiker.getAchternaam());
        System.out.println("- Woonplaats:  " + gebruiker.getWoonplaats());
        System.out.println("- Bezorgwijze: " + gebruiker.getBezorgwijzes().toString());
    }
}
