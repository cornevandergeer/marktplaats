package nl.corne.marktplaats.controller;

import nl.corne.marktplaats.view.HoofdMenuView;

public class ConsoleController {

    HoofdMenuView hoofdMenuView = new HoofdMenuView();
    GebruikerController gebruikerController = new GebruikerController();
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
                    System.out.println("binnenkort beschikbaar");
                    break;
                // registreren
                case "2":
                    gebruikerController.registreerGebruiker();
                    break;
            }
        }
    }
}
