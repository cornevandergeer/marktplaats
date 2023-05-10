package nl.corne.marktplaats.view;

import jakarta.inject.Singleton;

import java.util.Scanner;

@Singleton
public class HoofdMenuView {
    static Scanner scan = new Scanner(System.in);
    private String antwoord;

    public void laatHomePaginaZien() {
        System.out.println("" +
                "\n||-----------------------------------------------||" +
                "\n|| Welkom op Marktplaats voor de Belastingdienst ||" +
                "\n||-----------------------------------------------||" );
    }

    public void laatKeuzeMenuZien() {
        System.out.println("" +
                "\nWat wil je doen?" +
                "\n-------------------------------" +
                "\n| 1. inloggen                 |" +
                "\n| 2. registreren              |" +
                "\n   BINNENKORT BESCHIKBAAR:    " +
                "\n| X. gebruikersinfo bekijken  |" +
                "\n| X. gebruikersinfo aanpassen |" +
                "\n| X. advertenties bekijken    |" +
                "\n| X. advertentie plaatsen     |" +
                "\n| X. voorwaarden bekijken     |" +
                "\n| 8. afsluiten                |" +
                "\n-------------------------------");
    }

    public void vraagNummerUitKeuzemenu() {
        System.out.println("Typ het nummer uit het keuzemenu in:");
        setAntwoord();
        if (
                !(this.getAntwoord().equals("1")
                || this.getAntwoord().equals("2")
                || this.getAntwoord().equals("8"))) {
            System.out.println("Ik snap niet wat je bedoeld...");
            vraagNummerUitKeuzemenu();
        }
    }

    private void setAntwoord() {
        this.antwoord = scan.nextLine();
    }

    public String getAntwoord() {
        return antwoord;
    }
}
