package nl.corne.marktplaats;

import java.util.Scanner;

public class ConsoleUI {
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
                "\n-------------------------------");
    }

    public void vraagNummerUitKeuzemenu() {
        System.out.println("Typ het nummer uit het keuzemenu in:");
        setAntwoord();
        if (!(getAntwoord().equals("1") || getAntwoord().equals("2"))) {
            System.out.println("Ik snap niet wat je bedoeld...");
            laatKeuzeMenuZien();
            vraagNummerUitKeuzemenu();
        }
    }
    public String getAntwoord() {
        return antwoord;
    }
    public void setAntwoord() {
        this.antwoord = scan.nextLine();
    }
}
