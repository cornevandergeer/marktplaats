package nl.corne.marktplaats;

import java.util.HashMap;
import java.util.Scanner;

public class Gebruiker {
    static Scanner scan = new Scanner(System.in);
    private String gebruikersNaam;
    private String wachtwoord;
    private int id;
    private boolean isIngelogd;
    private Rol rol;
    private HashMap<Bezorgtypes, Boolean> bezorgwijze = new HashMap<>();

    public Gebruiker(String gebruikersNaam, String wachtwoord) {
        this.gebruikersNaam = gebruikersNaam;
        this.wachtwoord = wachtwoord;
        this.rol = Rol.HANDELAAR;
        this.isIngelogd = false;
        for (Bezorgtypes bezorgtype : Bezorgtypes.values()) {
            bezorgwijze.put(bezorgtype, false);
        }
    }

    public void setBezorgwijze(Bezorgtypes key, Boolean value)  {
        this.bezorgwijze.replace(key, value);
    }


    public static String vraagGebruikersNaam() {
        System.out.println("Wat is je gebruikersnaam? ");
        String gebruikersNaam = scan.nextLine();
        return gebruikersNaam;
    }

    public static String vraagWachtwoord() {
        System.out.println("Wat is je wachtwoord? ");
        String wachtwoord = scan.nextLine();
        return wachtwoord;
    }

    public String getGebruikersNaam() {
        return gebruikersNaam;
    }

    public void setGebruikersNaam(String naam) {
        this.gebruikersNaam = gebruikersNaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rol getRol() {
        return rol;
    }

    public boolean getIsIngelogd() {
        return isIngelogd;
    }

    public void setIsIngelogd(boolean status) {
        isIngelogd = status;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
