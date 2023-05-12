package nl.corne.marktplaats.view;

import jakarta.inject.Inject;
import nl.corne.marktplaats.model.advertentie.Advertentie;
import nl.corne.marktplaats.model.reactie.Reactie;
import nl.corne.marktplaats.model.reactie.ReactieDAO;

import java.util.List;
import java.util.Scanner;

public class AdvertentieGekozenMenuView {

    @Inject
    private ReactieDAO reactieDAO;

    static Scanner scan = new Scanner(System.in);
    private String antwoord;

    public void laatKeuzeMenuZien(){
        System.out.println("""
                Wat wilt u doen?
                --------------------------------------
                | 1. Plaats reactie                  |
                | 2. Plaats bod                      |
                | 3. Terug naar vorige menu          |
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

    public String vraagTekst(){
        System.out.println("Plaats uw reactie voor deze advertentie.");
        return scan.nextLine();
    }

    public void laatAlleReactiesZienVanAdvertentie(Advertentie advertentie) {
        List<Reactie> reacties = reactieDAO.getAllReactiesOfAdvertentie(advertentie);
        System.out.println("""
                
                Reacties
                --------------------------------------""");
        for (int i = 0; i < reacties.toArray().length ; i++) {
            System.out.println("| " + (i + 1) + ". \n" + reacties.get(i).printReacties());
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
