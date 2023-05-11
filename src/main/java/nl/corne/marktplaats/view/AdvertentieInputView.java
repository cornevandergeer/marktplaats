package nl.corne.marktplaats.view;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.log4j.Log4j;

import java.math.BigDecimal;
import java.util.Scanner;

@Singleton
public class AdvertentieInputView {

    Scanner scan = new Scanner(System.in);
    public String vraagHoofdcategorie() {
        System.out.println("Gaat het om een 'dienst' of een 'product'? ");
        String hoofdCategorie = scan.nextLine();
        return hoofdCategorie;
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
        System.out.println(prijsBigDecimal);
        return prijsBigDecimal;
    }

//    public String vraagOmschrijving() {
//        System.out.println();
//    }

    public static void main(String[] args) {
        AdvertentieInputView test = new AdvertentieInputView();
        test.vraagPrijs();
    }
}


