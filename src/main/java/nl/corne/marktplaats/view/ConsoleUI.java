package nl.corne.marktplaats.view;

import nl.corne.marktplaats.controller.GebruikerController;

public class ConsoleUI {

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
//                    gebruikerController.inlogGebruiker();
                    break;
                // registreren
                case "2":
                    gebruikerController.registreerGebruiker();
                    break;
            }
        }
    }
}
