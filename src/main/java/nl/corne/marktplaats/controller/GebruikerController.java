package nl.corne.marktplaats.controller;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import nl.corne.marktplaats.model.gebruiker.Bezorgwijze;
import nl.corne.marktplaats.model.gebruiker.BezorgwijzeDAO;
import nl.corne.marktplaats.model.gebruiker.Gebruiker;
import nl.corne.marktplaats.model.gebruiker.GebruikerDAO;
import nl.corne.marktplaats.view.BezorgwijzeView;
import nl.corne.marktplaats.view.GebruikerInfoMenuView;
import nl.corne.marktplaats.view.GebruikerInputView;

@Singleton
public class GebruikerController {

    @Inject
    private GebruikerDAO gebruikerDao;
    @Inject
    private BezorgwijzeDAO bezorgwijzeDAO;
    @Inject
    private GebruikerInputView gebruikerInputView;
    @Inject
    private BezorgwijzeView bezorgwijzeView;
    @Inject
    private GebruikerInfoMenuView gebruikerInfoMenuView;



    public void registreerGebruiker() {
        String username = gebruikerInputView.vraagEmail();
        String wachtwoord = gebruikerInputView.vraagWachtwoord();
        String voornaam = gebruikerInputView.vraagVoornaam();
        String achternaam = gebruikerInputView.vraagAchternaam();
        String woonplaats = gebruikerInputView.vraagWoonplaats();
        String favorieteProgrammeertaal = gebruikerInputView.vraagFavorieteProgrammeertaal();
        String versturen = bezorgwijzeView.vraagVersturen();
        String afhalen = bezorgwijzeView.vraagAfhalen();
        String depot = bezorgwijzeView.vraagDepot();

        Gebruiker gebruiker = Gebruiker.builder().username(username).wachtwoord(wachtwoord).voornaam(voornaam).achternaam(achternaam).woonplaats(woonplaats).favorieteProgrammeertaal(favorieteProgrammeertaal).build();
        bezorgwijzeDAO.addBezorgwijze(versturen, Bezorgwijze.VERSTUREN, gebruiker);
        bezorgwijzeDAO.addBezorgwijze(afhalen, Bezorgwijze.THUISAFHALEN, gebruiker);
        bezorgwijzeDAO.addBezorgwijze(depot, Bezorgwijze.MAGAZIJNBELASTINGDIENST, gebruiker);
        gebruiker.setBezorgwijzes(gebruiker.getBezorgwijzes());
        gebruikerDao.insert(gebruiker);
        System.out.println("Hallo " + voornaam + " " + achternaam + "," +
                "\njouw account is succesvol aangemaakt");
    }

    public Gebruiker inlogGebruiker() {
            String email = gebruikerInputView.vraagEmail();
            String wachtwoord = gebruikerInputView.vraagWachtwoord();
            Gebruiker gebruiker = gebruikerDao.inlogGebruiker(email, wachtwoord);
            if (gebruiker == null) {
                System.out.println("Gebruiker niet herkend, probeer opnieuw");
                return null;
            }
            System.out.println("Welkom " + gebruiker.getVoornaam() + " Je bent nu ingelogd!");
            return gebruiker;
    }

    public void uitlogGebruiker(Gebruiker gebruiker) {
        gebruikerDao.uitlogGebruiker(gebruiker.getUsername());
    }

    public void pasGebruikerInfoAan(Gebruiker gebruiker) {
        gebruikerInfoMenuView.laatKeuzeMenuZien();
        gebruikerInfoMenuView.vraagNummerUitKeuzemenu();

        switch (gebruikerInfoMenuView.getAntwoord()) {
            case "1": // wachtwoord
                String wachtwoord = gebruikerInputView.vraagWachtwoord();
                gebruiker.setWachtwoord(wachtwoord);
                break;
            case "2": // voornaam
                String voornaam = gebruikerInputView.vraagVoornaam();
                gebruiker.setVoornaam(voornaam);
                break;
            case "3": // achternaam
                String achternaam = gebruikerInputView.vraagAchternaam();
                gebruiker.setAchternaam(achternaam);
                break;
            case "4": // favoriete programmeertaal
                String favorieteProgrammeertaal = gebruikerInputView.vraagFavorieteProgrammeertaal();
                gebruiker.setFavorieteProgrammeertaal(favorieteProgrammeertaal);
                break;
            case "5": // woonplaats
                String woonplaats = gebruikerInputView.vraagWoonplaats();
                gebruiker.setWoonplaats(woonplaats);
                break;
            case "6": // bezorgwijzes aanpassen
                String versturen = bezorgwijzeView.vraagVersturen();
                String afhalen = bezorgwijzeView.vraagAfhalen();
                String depot = bezorgwijzeView.vraagDepot();
                bezorgwijzeDAO.addBezorgwijze(versturen, Bezorgwijze.VERSTUREN, gebruiker);
                bezorgwijzeDAO.addBezorgwijze(afhalen, Bezorgwijze.THUISAFHALEN, gebruiker);
                bezorgwijzeDAO.addBezorgwijze(depot, Bezorgwijze.MAGAZIJNBELASTINGDIENST, gebruiker);
                gebruiker.setBezorgwijzes(gebruiker.getBezorgwijzes());
                break;
            case "7": // terug naar hoofdmenu
                break;
        }
    }


}
