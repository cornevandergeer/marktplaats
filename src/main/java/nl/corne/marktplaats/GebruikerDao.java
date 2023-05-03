package nl.corne.marktplaats;

import java.util.ArrayList;


public class GebruikerDao {

    private ArrayList<Gebruiker> gebruikers = new ArrayList<>();
    private static GebruikerDao gebruikerDao = new GebruikerDao();

    private GebruikerDao() {
    }

    public void registreerGebruiker() {
        String gebruikersNaam = Gebruiker.vraagGebruikersNaam();
        String wachtwoord = Gebruiker.vraagWachtwoord();
        Gebruiker gebruiker = new Gebruiker(gebruikersNaam, wachtwoord);
        gebruiker.setId(gebruikers.size());
        this.addGebruiker(gebruiker);
        System.out.println("Hallo " + gebruikersNaam + "," +
                "\njouw account is aangemaakt met id nummer: " + gebruiker.getId());
    }

    public void inlogGebruiker() {
        String gebruikersNaam = Gebruiker.vraagGebruikersNaam();
        String wachtwoord = Gebruiker.vraagWachtwoord();
        for (int i = 0; i < gebruikers.size(); i++) {
            Gebruiker gebruiker = gebruikers.get(i);
            if (gebruikersNaam.equals(gebruiker.getGebruikersNaam())
                    && wachtwoord.equals(gebruiker.getWachtwoord())) {
                System.out.println("Welkom " + gebruikersNaam);
                gebruiker.setIsIngelogd(true);
                return;
            }
        }
        System.out.println("Wachtwoord en/of gebruikersnaam niet herkend, probeer opnieuw...");
        this.inlogGebruiker();
    }

    public void addGebruiker(Gebruiker gebruiker) {
        this.gebruikers.add(gebruiker);
    }

    public Gebruiker getGebruiker(int id) {
        return gebruikers.get(id);
    }

    public static GebruikerDao getGebruikerDao() {
        return gebruikerDao;
    }

}
