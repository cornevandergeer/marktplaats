package nl.corne.marktplaats.controller;
import nl.corne.marktplaats.model.*;
import nl.corne.marktplaats.view.BezorgwijzeView;
import nl.corne.marktplaats.view.GebruikerView;

public class GebruikerController {

    private GebruikerDao gebruikerDao = new GebruikerDao();
    private BezorgwijzeDao bezorgwijzeDao = new BezorgwijzeDao();
    private GebruikerView gebruikerView = new GebruikerView();
    private BezorgwijzeView bezorgwijzeView = new BezorgwijzeView();
    public void registreerGebruiker() {
        String email = gebruikerView.vraagEmail();
        String wachtwoord = gebruikerView.vraagWachtwoord();
        String voornaam = gebruikerView.vraagVoornaam();
        String achternaam = gebruikerView.vraagAchternaam();
        String favorieteProgrammeertaal = gebruikerView.vraagFavorieteProgrammeertaal();
        Gebruiker gebruiker = new Gebruiker(email, wachtwoord, voornaam, achternaam, favorieteProgrammeertaal);
        gebruikerDao.create(gebruiker);
        setBezorgwijzes(gebruiker);
        System.out.println("Hallo " + voornaam + " " + achternaam + "," +
                "\njouw account is succesvol aangemaakt");
    }

    public void setBezorgwijzes(Gebruiker gebruiker) {
        Bezorgwijze bezorgwijze = new Bezorgwijze();
        boolean bezorgen = bezorgwijzeView.vraagBezorgen();
        boolean afhalen = bezorgwijzeView.vraagAfhalen();
        boolean depot = bezorgwijzeView.vraagDepot();
        bezorgwijze.setBezorgen(bezorgen);
        bezorgwijze.setAfhalen(afhalen);
        bezorgwijze.setDepot(depot);
        bezorgwijzeDao.create(bezorgwijze);
        gebruiker.setBezorgwijzes(bezorgwijze);
        bezorgwijzeDao.update(bezorgwijze);
    }

    public void inlogGebruiker() {
            String email = gebruikerView.vraagEmail();
            String wachtwoord = gebruikerView.vraagWachtwoord();
            Gebruiker gebruiker = gebruikerDao.inlogGebruiker(email, wachtwoord);
            if (gebruiker == null) {
                System.out.println("Gebruiker niet herkend, probeer opnieuw");
                return;
            }
            System.out.println("Welkom " + gebruiker.getVoornaam() + " Je bent nu ingelogd!");
    }

}
