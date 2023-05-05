package nl.corne.marktplaats.view;

import java.util.Scanner;

public class GebruikerView {

    Scanner scan = new Scanner(System.in);

    public String vraagGebruikersNaam() {
        System.out.println("Wat is je gebruikersnaam? ");
        String gebruikersNaam = scan.nextLine();
        return gebruikersNaam;
    }

    public String vraagWachtwoord() {
        System.out.println("Wat is je wachtwoord? ");
        String wachtwoord = scan.nextLine();
        return wachtwoord;
    }
}
