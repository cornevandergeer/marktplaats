package nl.corne.marktplaats.view;

import jakarta.inject.Inject;
import nl.corne.marktplaats.model.advertentie.Advertentie;
import nl.corne.marktplaats.model.bod.BodDAO;
import nl.corne.marktplaats.model.gebruiker.Gebruiker;
import nl.corne.marktplaats.model.gebruiker.GebruikerDAO;
import nl.corne.marktplaats.model.reactie.Reactie;
import nl.corne.marktplaats.model.reactie.ReactieDAO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class AdvertentieGekozenMenuView {

    @Inject
    private ReactieDAO reactieDAO;
    @Inject
    private BodDAO bodDAO;
    @Inject
    private GebruikerDAO gebruikerDAO;

    static Scanner scan = new Scanner(System.in);
    private String antwoord;

    public void laatKeuzeMenuZien(){
        System.out.println("""
                Wat wil je doen?
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
        System.out.println("Plaats je reactie voor deze advertentie.");
        return scan.nextLine();
    }

    public BigDecimal vraagBod(Advertentie advertentie){
        System.out.println("Wat is jouw bod?");
        String bod = scan.nextLine();
        bod = bod.replaceAll(",",".");
        Double bodDouble;
        try {
            bodDouble = Double.parseDouble(bod);
        } catch (NumberFormatException e) {
            System.out.println("Bod moet een getal zijn");
            return vraagBod(advertentie);
        }
        BigDecimal bodBigDecimal = BigDecimal.valueOf(bodDouble);
        if (!bodDAO.checkIfBodIsPresentForAdvertentie(advertentie)){
            return bodBigDecimal;
        }
        if (bodBigDecimal.doubleValue() <= bodDAO.get(advertentie).getBedrag().doubleValue()){
        System.out.println("Bod moet hoger zijn dan het huidige bod.");
        return vraagBod(advertentie);
          }
        if (bodBigDecimal.doubleValue() < 0) {
            System.out.println("Bod mag niet lager zijn dan 0");
            return vraagBod(advertentie);
        }
        return bodBigDecimal;
    }

    public void laatBodZienVanAdvertentie(Advertentie advertentie) {
        if (bodDAO.checkIfBodIsPresentForAdvertentie(advertentie)){
            Gebruiker biedendeGebruiker = bodDAO.get(advertentie).getGebruiker();
            System.out.println(
                            "|Huidig bod \n" +
                            "|___________________________________________________\n" +
                            "| Bedrag:    €" + bodDAO.get(advertentie).getBedrag()+"\n" +
                            "| Bieder:    "  + biedendeGebruiker.getUsername() + "\n" +
                            "| Datum bod: " + bodDAO.get(advertentie).formattedTimestamp() + "\n" +
                            "|____________________________________________________"
    );
        } else {
            System.out.println("""
                    
                    --------------------------------------
                    Nog geen bod geplaatst.
                    --------------------------------------
                    """);
        }
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
