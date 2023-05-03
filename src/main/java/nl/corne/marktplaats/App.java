package nl.corne.marktplaats;

public class App {

    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
        GebruikerDao gebruikerDao = GebruikerDao.getGebruikerDao();
        Beheerder.getBeheerder();

        while (true) {
            // Home pagina
            consoleUI.laatHomePaginaZien();
            // Laat menu zien
            consoleUI.laatKeuzeMenuZien();
            // Vraag nummer uit keuzemenu
            consoleUI.vraagNummerUitKeuzemenu();

            switch (consoleUI.getAntwoord()) {
                // inloggen
                case "1":
                    gebruikerDao.inlogGebruiker();
                    break;
                // registreren
                case "2":
                    gebruikerDao.registreerGebruiker();
                    break;
            }
        }
    }
}
