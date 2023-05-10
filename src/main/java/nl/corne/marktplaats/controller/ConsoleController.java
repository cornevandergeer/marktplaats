package nl.corne.marktplaats.controller;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import nl.corne.marktplaats.model.gebruiker.Gebruiker;
import nl.corne.marktplaats.view.HoofdMenuView;

@Singleton
public class ConsoleController {

    Gebruiker gebruiker;

    @Inject
    HoofdMenuView hoofdMenuView;
    @Inject
    GebruikerController gebruikerController;
    public void runConsole() {
        while (true) {
            // Home pagina
            hoofdMenuView.laatHomePaginaZien();
            // Laat menu zien
            hoofdMenuView.laatKeuzeMenuZien();
            // Vraag nummer uit keuzemenu
            hoofdMenuView.vraagNummerUitKeuzemenu();

            switch (hoofdMenuView.getAntwoord()) {
                // inloggen
                case "1":
                    gebruiker = gebruikerController.inlogGebruiker();
                    break;
                // registreren
                case "2":
                    gebruikerController.registreerGebruiker();
                    break;
                case "3":
                    System.out.println(gebruiker);
                    break;
                case "4":
//                    gebruikerController.();
                    System.out.println("grapje, toch nog niet beschikbaar");
                    break;
                case "8":
                    System.out.println("Bedankt en tot ziens!");
                    gebruikerController.uitlogGebruiker(gebruiker);
                    return;
            }
        }
    }
}
