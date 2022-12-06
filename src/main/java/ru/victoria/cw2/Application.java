package ru.victoria.cw2;

import ru.victoria.cw2.game.Game;
import ru.victoria.cw2.services.ConfigurationManager;

public class Application {
    public static void main(String[] args) {
        ConfigurationManager.getScenarioConfiguration();
        Game game = new Game();
        game.run();
    }
}
