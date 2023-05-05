package nl.corne.marktplaats.controller;
import nl.corne.marktplaats.model.Gebruiker;
import nl.corne.marktplaats.model.GebruikerDao;
import nl.corne.marktplaats.view.GebruikerView;

public class GebruikerController {

    private GebruikerDao gebruikerDao = new GebruikerDao();
    private GebruikerView gebruikerView = new GebruikerView();
    public void registreerGebruiker() {
        String gebruikersNaam = gebruikerView.vraagGebruikersNaam();
        String wachtwoord = gebruikerView.vraagWachtwoord();
        Gebruiker gebruiker = new Gebruiker(gebruikersNaam, wachtwoord);
        gebruikerDao.insert(gebruiker);
        System.out.println("Hallo " + gebruikersNaam + "," +
                "\njouw account is succesvol aangemaakt");
    }
}
