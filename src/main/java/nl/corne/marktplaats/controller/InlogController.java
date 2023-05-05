package nl.corne.marktplaats.controller;

import nl.corne.marktplaats.model.Gebruiker;
import nl.corne.marktplaats.model.GebruikerDao;

//public class InlogController {
//
//    InlogView inlogView;
//    GebruikerDao gebruikerDao;
//    public void inlogGebruiker() {
//        String gebruikersNaam = inlogView.vraagGebruikersNaam();
//        String wachtwoord = inlogView.vraagWachtwoord();
//        for (int i = 0; i < gebruikerDao.getGebruikers().size(); i++) {
//            Gebruiker gebruiker = gebruikerDao.getGebruiker(i);
//            if (gebruikersNaam.equals(gebruiker.getGebruikersNaam())
//                    && wachtwoord.equals(gebruiker.getWachtwoord())) {
//                System.out.println("Welkom " + gebruikersNaam);
//                gebruiker.setIsIngelogd(true);
//                return;
//            }
//        }
//        System.out.println("Wachtwoord en/of gebruikersnaam niet herkend, probeer opnieuw...");
//        this.inlogGebruiker();
//    }
//}
