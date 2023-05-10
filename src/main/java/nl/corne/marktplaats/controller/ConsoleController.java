package nl.corne.marktplaats.controller;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import nl.corne.marktplaats.view.HoofdMenuView;

@Singleton
public class ConsoleController {

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
                    gebruikerController.inlogGebruiker();
                    break;
                // registreren
                case "2":
                    gebruikerController.registreerGebruiker();
                    break;
                case "8":
                    System.out.println("Bedankt en tot ziens!");
                    return;
            }
        }
    }
}
