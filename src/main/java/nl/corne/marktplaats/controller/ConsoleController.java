package nl.corne.marktplaats.controller;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import nl.corne.marktplaats.model.gebruiker.Gebruiker;
import nl.corne.marktplaats.view.GebruikerOutputView;
import nl.corne.marktplaats.view.HoofdMenuView;

@Singleton
public class ConsoleController {

    Gebruiker gebruiker;

    @Inject
    HoofdMenuView hoofdMenuView;
    @Inject
    GebruikerController gebruikerController;
    @Inject
    GebruikerOutputView gebruikerOutputView;

    public void runConsole() {
        while (true) {
            // Home pagina
            hoofdMenuView.laatHomePaginaZien();
            if (gebruiker == null) {
                // Laat menu zien voor gast
                hoofdMenuView.laatGastMenuZien();
                // Vraag nummer uit keuzemenu voor gast
                hoofdMenuView.vraagNummerUitGastKeuzeMenu();

                switch (hoofdMenuView.getAntwoord()) {
                    case "1": // inloggen
                        gebruiker = gebruikerController.inlogGebruiker();
                        break;
                    case "2": // registreren
                        gebruikerController.registreerGebruiker();
                        break;
                }

            } else {
                hoofdMenuView.laatKeuzeMenuZien();
                hoofdMenuView.vraagNummerUitKeuzemenu();

                switch (hoofdMenuView.getAntwoord()) {
                    case "1": // gebruikersinfo bekijken
                        gebruikerOutputView.gebruikerGegevens(gebruiker);
                        break;
                    case "2": // gebruikersinfo aanpassen
                        gebruikerController.pasGebruikerInfoAan(gebruiker);
                        break;
                    case "6": // afsluiten en uitloggen
                        System.out.println("Bedankt en tot ziens!");
                        gebruikerController.uitlogGebruiker(gebruiker);
                        return;
                }

            }

        }
    }
}
