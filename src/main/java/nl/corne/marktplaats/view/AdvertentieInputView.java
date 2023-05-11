package nl.corne.marktplaats.view;

import jakarta.inject.Singleton;
import nl.corne.marktplaats.model.gebruiker.Gebruiker;

import java.math.BigDecimal;
import java.util.Scanner;

@Singleton
public class AdvertentieInputView {

    Scanner scan = new Scanner(System.in);

    public String vraagHoofdcategorie() {
        System.out.println("Gaat het om een 'dienst' of een 'product'? ");
        String hoofdCategorie = scan.nextLine();
        hoofdCategorie = hoofdCategorie.toLowerCase().trim();
        if (hoofdCategorie.equals("dienst") || hoofdCategorie.equals("product")) {
            return hoofdCategorie;
        } else {
            System.out.println("ik snap niet wat je bedoeld.");
            return vraagHoofdcategorie();
        }
    }

    public String vraagTitel() {
        System.out.println("Wat is de titel van je advertentie?");
        String titel = scan.nextLine();
        return titel;
    }

    public BigDecimal vraagPrijs() {
        System.out.println("Wat is de prijs van je advertentie?");
        String prijs = scan.nextLine();
        prijs = prijs.replaceAll(",",".");
        Double prijsDouble;
        try {
            prijsDouble = Double.parseDouble(prijs);
        } catch (NumberFormatException e) {
            System.out.println("prijs moet een getal zijn");
            return vraagPrijs();
        }
        BigDecimal prijsBigDecimal = BigDecimal.valueOf(prijsDouble);
        return prijsBigDecimal;
    }

    public String vraagOmschrijving() {
        System.out.println("Wat is de omschrijving van je advertentie?");
        String omschrijving = scan.nextLine();
        return omschrijving;
    }

    public String vraagBezorgwijze(Gebruiker gebruiker) {
        if (gebruiker.getBezorgwijzes().size() == 1) {
            return gebruiker.getBezorgwijzes().toArray()[0].toString().toUpperCase().replaceAll("\\s+","");
        } else {
            return kiesOptieBezorgwijze(gebruiker);
        }
    }

    public String kiesOptieBezorgwijze(Gebruiker gebruiker) {
        for (int i = 0; i < gebruiker.getBezorgwijzes().size(); i++) {
            System.out.println("Kies optie: '" + (i+1) + "' voor " + gebruiker.getBezorgwijzes().toArray()[i].toString());
        }
        String antwoord = scan.nextLine();
        int a;
        try {
            a = Integer.parseInt(antwoord);
        } catch (NumberFormatException e) {
            System.out.println("optie niet herkend, probeer opnieuw");
            return kiesOptieBezorgwijze(gebruiker);
        }

        if (a > gebruiker.getBezorgwijzes().size() || a <= 0) {
            System.out.println("optie niet herkend, probeer opnieuw");
            return kiesOptieBezorgwijze(gebruiker);
        }
        return gebruiker.getBezorgwijzes().toArray()[a-1].toString().toUpperCase().replaceAll("\\s+","");
    }


}


