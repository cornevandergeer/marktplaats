package nl.corne.marktplaats.view;


import jakarta.inject.Singleton;

import java.util.Scanner;

@Singleton
public class GebruikerView {

    Scanner scan = new Scanner(System.in);

    public String vraagEmail() {
        System.out.println("Wat is je email? ");
        String gebruikersNaam = scan.nextLine();
        return gebruikersNaam;
    }

    public String vraagWoonplaats() {
        System.out.println("Wat is je woonplaats? ");
        String woonplaats = scan.nextLine();
        return woonplaats;
    }

    public String vraagWachtwoord() {
        System.out.println("Wat is je wachtwoord? ");
        String wachtwoord = scan.nextLine();
        return wachtwoord;
    }

    public String vraagVoornaam() {
        System.out.println("Wat is je voornaam? ");
        String voornaam = scan.nextLine();
        return voornaam;
    }
    public String vraagAchternaam() {
        System.out.println("Wat is je achternaam? ");
        String achternaam = scan.nextLine();
        return achternaam;
    }

    public String vraagFavorieteProgrammeertaal() {
        System.out.println("Wat is je favoriete programmeertaal? ");
        String favorieteProgrammeertaal = scan.nextLine();
        return favorieteProgrammeertaal;
    }

}
