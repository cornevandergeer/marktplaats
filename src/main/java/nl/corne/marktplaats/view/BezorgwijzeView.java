package nl.corne.marktplaats.view;

import jakarta.inject.Singleton;

import java.util.Scanner;

@Singleton
public class BezorgwijzeView {

    Scanner scan = new Scanner(System.in);

    public String vraagVersturen() {
        System.out.println("Wil je verzendoptie 'Versturen' aanzetten? (ja/nee)");
        String antwoord = scan.nextLine();
        if (antwoord.equals("ja")) {
            return "VERSTUREN";
        } else {
            return "";
        }
    }
    public String vraagAfhalen() {
        System.out.println("Wil je verzendoptie 'Afhalen' aanzetten? (ja/nee)");
        String antwoord = scan.nextLine();
        if (antwoord.equals("ja")) {
            return "THUISAFHALEN";
        } else {
            return "";
        }
    }
    public String vraagDepot() {
        System.out.println("Wil je verzendoptie 'Depot' aanzetten? (ja/nee)");
        String antwoord = scan.nextLine();
        if (antwoord.equals("ja")) {
            return "MAGAZIJNBELASTINGDIENST";
        } else {
            return "";
        }
    }


}
