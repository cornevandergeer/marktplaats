package nl.corne.marktplaats;


import jakarta.enterprise.inject.se.SeContainer;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import nl.corne.marktplaats.controller.ConsoleController;
import org.jboss.weld.environment.se.Weld;

@Singleton
public class App {

    @Inject
    ConsoleController consoleController;

    public static void main(String[] args) {
        try (SeContainer container = Weld.newInstance().initialize()) {
            App app = container.select(App.class).get();
            app.run();
        }
    }

    private void run() {
        consoleController.runConsole();
    }
}
