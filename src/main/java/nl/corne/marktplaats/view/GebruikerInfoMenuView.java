package nl.corne.marktplaats.view;

import jakarta.inject.Singleton;

import java.util.Scanner;

@Singleton
public class GebruikerInfoMenuView {
    static Scanner scan = new Scanner(System.in);
    private String antwoord;

    public void laatKeuzeMenuZien() {
        System.out.println("" +
                "\nWat wil je aanpassen?" +
                "\n--------------------------------------" +
                "\n| 1. wachtwoord                      |" +
                "\n| 2. voornaam                        |" +
                "\n| 3. achternaam                      |" +
                "\n| 4. favoriete programmeertaal       |" +
                "\n| 5. woonplaats                      |" +
                "\n| 6. bezorgwijzes aanpassen          |" +
                "\n| 7. OPSLAAN en terug naar hoofdmenu |" +
                "\n--------------------------------------");
    }

    public void vraagNummerUitKeuzemenu() {
        System.out.println("Typ het nummer uit het keuzemenu in:");
        setAntwoord();
        if (
                !(this.getAntwoord().equals("1")
                        || this.getAntwoord().equals("2")
                        || this.getAntwoord().equals("3")
                        || this.getAntwoord().equals("4")
                        || this.getAntwoord().equals("5")
                        || this.getAntwoord().equals("6")
                        || this.getAntwoord().equals("7"))) {
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
