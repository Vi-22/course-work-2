package ru.victoria.cw2.command;

import ru.victoria.cw2.game.Game;

public class MainMenuCommand implements Command{
    public Game game;
    private static final String name = "Главное меню";

    public MainMenuCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.extendMainMenu();
    }

    @Override
    public String getName() {
        return MainMenuCommand.name;
    }
}
