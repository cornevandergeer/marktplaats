package nl.corne.marktplaats.view;

import jakarta.inject.Singleton;

import java.util.Scanner;

@Singleton
public class BezorgwijzeView {

    Scanner scan = new Scanner(System.in);

    public String vraagVersturen() {
        System.out.println("Wil je verzendoptie 'Versturen' aanzetten? (ja/nee)");
        String antwoord = scan.nextLine();
        antwoord = antwoord.toLowerCase().trim();
        if (antwoord.equals("ja")) {
            return "VERSTUREN";
        } else if (antwoord.equals("nee")) {
            return "";
        } else {
            System.out.println("ik snap niet wat je bedoeld");
            return vraagVersturen();
        }
    }

    public String vraagAfhalen() {
        System.out.println("Wil je verzendoptie 'Afhalen' aanzetten? (ja/nee)");
        String antwoord = scan.nextLine();
        antwoord = antwoord.toLowerCase().trim();
        if (antwoord.equals("ja")) {
            return "THUISAFHALEN";
        } else if (antwoord.equals("nee")) {
            return "";
        } else {
            System.out.println("ik snap niet wat je bedoeld");
            return vraagAfhalen();
        }
    }

    public String vraagDepot() {
        System.out.println("Wil je verzendoptie 'Depot' aanzetten? (ja/nee)");
        String antwoord = scan.nextLine();
        antwoord = antwoord.toLowerCase().trim();
        if (antwoord.equals("ja")) {
            return "MAGAZIJNBELASTINGDIENST";
        } else if (antwoord.equals("nee")) {
            return "";
        } else {
            System.out.println("ik snap niet wat je bedoeld");
            return vraagDepot();
        }
    }


}
