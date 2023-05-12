package nl.corne.marktplaats.view;

import java.util.Scanner;

public class AdvertentieInfoMenuView {

    static Scanner scan = new Scanner(System.in);
    private String antwoord;

    public void laatKeuzeMenuZien(){
        System.out.println("""
                Wat wilt u doen?
                --------------------------------------
                | 1. zie advertentie nummer #        |
                | 2. Sorteer advertenties            |
                | 3. Terug naar hoofdmenu            |
                --------------------------------------
                """);
    }

    public void vraagNummerUitKeuzeMenu() {
        System.out.println("Typ het nummer uit het keuzemenu in:");
        setAntwoord();
        if (
                !(this.getAntwoord().equals("1")
                        || this.getAntwoord().equals("2")
                        || this.getAntwoord().equals("3"))) {
            System.out.println("Ik snap niet wat je bedoeld...");
            vraagNummerUitKeuzeMenu();
        }
    }
    private void setAntwoord() {
        this.antwoord = scan.nextLine();
    }

    public String getAntwoord() {
        return antwoord;
    }
}
