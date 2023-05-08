package nl.corne.marktplaats.view;

import java.util.Scanner;

public class BezorgwijzeView {

    Scanner scan = new Scanner(System.in);

    public boolean vraagBezorgen() {
        System.out.println("Wil je verzendoptie 'Bezorgen' aanzetten? (ja/nee)");
        String antwoord = scan.nextLine();
        if (antwoord.equals("ja")) {
            return true;
        } else {
            return false;
        }
    }
    public boolean vraagAfhalen() {
        System.out.println("Wil je verzendoptie 'Afhalen' aanzetten? (ja/nee)");
        String antwoord = scan.nextLine();
        if (antwoord.equals("ja")) {
            return true;
        } else {
            return false;
        }
    }
    public boolean vraagDepot() {
        System.out.println("Wil je verzendoptie 'Depot' aanzetten? (ja/nee)");
        String antwoord = scan.nextLine();
        if (antwoord.equals("ja")) {
            return true;
        } else {
            return false;
        }
    }


}
