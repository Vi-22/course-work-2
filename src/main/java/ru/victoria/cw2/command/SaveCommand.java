package ru.victoria.cw2.command;

import ru.victoria.cw2.game.Game;

public class SaveCommand implements Command{
    public Game game;
    private static final String name = "Сохранить игру";

    public SaveCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.save();
    }

    @Override
    public String getName() {
        return SaveCommand.name;
    }
}
