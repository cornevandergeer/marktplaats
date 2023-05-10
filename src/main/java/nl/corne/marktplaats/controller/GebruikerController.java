package nl.corne.marktplaats.controller;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import nl.corne.marktplaats.model.gebruiker.Bezorgwijze;
import nl.corne.marktplaats.model.gebruiker.BezorgwijzeDAO;
import nl.corne.marktplaats.model.gebruiker.Gebruiker;
import nl.corne.marktplaats.model.gebruiker.GebruikerDAO;
import nl.corne.marktplaats.view.BezorgwijzeView;
import nl.corne.marktplaats.view.GebruikerView;

@Singleton
public class GebruikerController {

    @Inject
    private GebruikerDAO gebruikerDao;
    @Inject
    private BezorgwijzeDAO bezorgwijzeDAO;
    @Inject
    private GebruikerView gebruikerView;
    @Inject
    private BezorgwijzeView bezorgwijzeView;



    public void registreerGebruiker() {
        String username = gebruikerView.vraagEmail();
        String wachtwoord = gebruikerView.vraagWachtwoord();
        String voornaam = gebruikerView.vraagVoornaam();
        String achternaam = gebruikerView.vraagAchternaam();
        String woonplaats = gebruikerView.vraagWoonplaats();
        String favorieteProgrammeertaal = gebruikerView.vraagFavorieteProgrammeertaal();
        Gebruiker gebruiker = Gebruiker.builder().username(username).wachtwoord(wachtwoord).voornaam(voornaam).achternaam(achternaam).woonplaats(woonplaats).favorieteProgrammeertaal(favorieteProgrammeertaal).build();
        gebruikerDao.insert(gebruiker);
        setBezorgwijzes(gebruiker);
        System.out.println("Hallo " + voornaam + " " + achternaam + "," +
                "\njouw account is succesvol aangemaakt");
    }

    public void setBezorgwijzes(Gebruiker gebruiker) {
        String versturen = bezorgwijzeView.vraagVersturen();
        String afhalen = bezorgwijzeView.vraagAfhalen();
        String depot = bezorgwijzeView.vraagDepot();
        bezorgwijzeDAO.addBezorgwijze(versturen, Bezorgwijze.VERSTUREN, gebruiker);
        bezorgwijzeDAO.addBezorgwijze(afhalen, Bezorgwijze.THUISAFHALEN, gebruiker);
        bezorgwijzeDAO.addBezorgwijze(depot, Bezorgwijze.MAGAZIJNBELASTINGDIENST, gebruiker);
        bezorgwijzeDAO.insertBezorgwijzes(gebruiker);
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
