package nl.corne.marktplaats.controller;
import nl.corne.marktplaats.model.gebruiker.Gebruiker;
import nl.corne.marktplaats.model.gebruiker.GebruikerDAO;
import nl.corne.marktplaats.view.BezorgwijzeView;
import nl.corne.marktplaats.view.GebruikerView;

public class GebruikerController {

    private GebruikerDAO gebruikerDao = new GebruikerDAO();
    private GebruikerView gebruikerView = new GebruikerView();
    private BezorgwijzeView bezorgwijzeView = new BezorgwijzeView();
    public void registreerGebruiker() {
        String username = gebruikerView.vraagEmail();
        String wachtwoord = gebruikerView.vraagWachtwoord();
        String voornaam = gebruikerView.vraagVoornaam();
        String achternaam = gebruikerView.vraagAchternaam();
        String favorieteProgrammeertaal = gebruikerView.vraagFavorieteProgrammeertaal();
        Gebruiker gebruiker = Gebruiker.builder().username(username).wachtwoord(wachtwoord).voornaam(voornaam).achternaam(achternaam).favorieteProgrammeertaal(favorieteProgrammeertaal).build();
        gebruikerDao.insert(gebruiker);
        System.out.println("Hallo " + voornaam + " " + achternaam + "," +
                "\njouw account is succesvol aangemaakt");
    }

    public void setBezorgwijzes(Gebruiker gebruiker) {
        boolean bezorgen = bezorgwijzeView.vraagBezorgen();
        boolean afhalen = bezorgwijzeView.vraagAfhalen();
        boolean depot = bezorgwijzeView.vraagDepot();
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
