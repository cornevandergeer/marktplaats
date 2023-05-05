package nl.corne.marktplaats.controller;
import nl.corne.marktplaats.model.Gebruiker;
import nl.corne.marktplaats.model.GebruikerDao;
import nl.corne.marktplaats.view.GebruikerView;

public class GebruikerController {

    private GebruikerDao gebruikerDao = new GebruikerDao();
    private GebruikerView gebruikerView = new GebruikerView();
    public void registreerGebruiker() {
        String email = gebruikerView.vraagEmail();
        String wachtwoord = gebruikerView.vraagWachtwoord();
        String voornaam = gebruikerView.vraagVoornaam();
        String achternaam = gebruikerView.vraagAchternaam();
        String favorieteProgrammeertaal = gebruikerView.vraagFavorieteProgrammeertaal();
        Gebruiker gebruiker = new Gebruiker(email, wachtwoord, voornaam, achternaam, favorieteProgrammeertaal);
        gebruikerDao.insert(gebruiker);
        System.out.println("Hallo " + voornaam + " " + achternaam + "," +
                "\njouw account is succesvol aangemaakt");
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
