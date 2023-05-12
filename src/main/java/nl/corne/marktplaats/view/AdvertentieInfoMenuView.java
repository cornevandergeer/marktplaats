package nl.corne.marktplaats.view;

import jakarta.inject.Inject;
import nl.corne.marktplaats.model.advertentie.Advertentie;
import nl.corne.marktplaats.model.advertentie.AdvertentieDAO;

import java.util.List;
import java.util.Scanner;

public class AdvertentieInfoMenuView {

    @Inject
    private AdvertentieDAO advertentieDAO;

    static Scanner scan = new Scanner(System.in);
    private String antwoord;

    public void laatKeuzeMenuZien(){
        System.out.println("""
                Wat wilt u doen?
                --------------------------------------
                | 1. Zie advertentie nummer #        |
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

    public int vraagAdvertentieNummer() {
        System.out.println("Typ het ID-nummer van de advertentie die je wil bekijken:");
        setAntwoord();
        int antw;
        try{
            antw = Integer.valueOf(getAntwoord());
        } catch (NumberFormatException e) {
            System.out.println("Voer een getal in");
            return vraagAdvertentieNummer();
        }
        int aantalAdvertenties =  advertentieDAO.getAll().size();
        if (antw > aantalAdvertenties || antw < 1) {
            System.out.println("Deze advertentie bestaat niet");
            return vraagAdvertentieNummer();
        }
        return antw;
    }
    
    public void laatAlleAdvertentiesZien() {
        List<Advertentie> advertenties = advertentieDAO.getAllBeschikbareAdvertenties();
        System.out.println("""
                
                Advertenties
                --------------------------------------""");
        for (int i = 0; i < advertenties.toArray().length ; i++) {
            System.out.println("| " + (i + 1) + ". \n" + advertenties.get(i).printSimpelOverzicht());
        }
        System.out.println("""
                --------------------------------------
                """);
    }
    
    private void setAntwoord() {
        this.antwoord = scan.nextLine();
    }

    public String getAntwoord() {
        return antwoord;
    }
}
