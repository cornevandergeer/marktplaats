package nl.corne.marktplaats.controller;
import nl.corne.marktplaats.model.gebruiker.Bezorgwijze;
import nl.corne.marktplaats.model.gebruiker.GebruikerDaoOud;
import nl.corne.marktplaats.model.gebruiker.GebruikerOud;
import nl.corne.marktplaats.view.BezorgwijzeView;
import nl.corne.marktplaats.view.GebruikerView;

public class GebruikerController {

    private GebruikerDaoOud gebruikerDaoOud = new GebruikerDaoOud();
    private BezorgwijzeDao bezorgwijzeDao = new BezorgwijzeDao();
    private GebruikerView gebruikerView = new GebruikerView();
    private BezorgwijzeView bezorgwijzeView = new BezorgwijzeView();
    public void registreerGebruiker() {
        String email = gebruikerView.vraagEmail();
        String wachtwoord = gebruikerView.vraagWachtwoord();
        String voornaam = gebruikerView.vraagVoornaam();
        String achternaam = gebruikerView.vraagAchternaam();
        String favorieteProgrammeertaal = gebruikerView.vraagFavorieteProgrammeertaal();
        GebruikerOud gebruikerOud = new GebruikerOud(email, wachtwoord, voornaam, achternaam, favorieteProgrammeertaal);
        gebruikerDaoOud.create(gebruikerOud);
        setBezorgwijzes(gebruikerOud);
        System.out.println("Hallo " + voornaam + " " + achternaam + "," +
                "\njouw account is succesvol aangemaakt");
    }

    public void setBezorgwijzes(GebruikerOud gebruikerOud) {
        Bezorgwijze bezorgwijze = new Bezorgwijze();
        boolean bezorgen = bezorgwijzeView.vraagBezorgen();
        boolean afhalen = bezorgwijzeView.vraagAfhalen();
        boolean depot = bezorgwijzeView.vraagDepot();
        bezorgwijze.setBezorgen(bezorgen);
        bezorgwijze.setAfhalen(afhalen);
        bezorgwijze.setDepot(depot);
        bezorgwijzeDao.create(bezorgwijze);
        gebruikerOud.setBezorgwijzes(bezorgwijze);
        bezorgwijzeDao.update(bezorgwijze);
    }

    public void inlogGebruiker() {
            String email = gebruikerView.vraagEmail();
            String wachtwoord = gebruikerView.vraagWachtwoord();
            GebruikerOud gebruikerOud = gebruikerDaoOud.inlogGebruiker(email, wachtwoord);
            if (gebruikerOud == null) {
                System.out.println("Gebruiker niet herkend, probeer opnieuw");
                return;
            }
            System.out.println("Welkom " + gebruikerOud.getVoornaam() + " Je bent nu ingelogd!");
    }

}
