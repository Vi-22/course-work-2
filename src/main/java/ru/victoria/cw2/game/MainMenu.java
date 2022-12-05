package ru.victoria.cw2.game;

import ru.victoria.cw2.command.*;

import java.util.TreeMap;

public class MainMenu extends Menu {
    public MainMenu() {
        super(new TreeMap<>());
    }

    public void setStandartMainMenu(Game game) {
        setHead("Главное меню: ");
        CreateNewCommand createNewGame = new CreateNewCommand(game);
        RestoreCommand restoreGame = new RestoreCommand(game);
        ExitCommand exitGame = new ExitCommand(game);
        getBottoms().put(1, createNewGame);
        getBottoms().put(2, restoreGame);
        getBottoms().put(3, exitGame);
    }
    public void setExtendMainMenu(Game game) {
        setHead("Главное меню: ");
        CreateNewCommand createNewGame = new CreateNewCommand(game);
        RestoreCommand restoreGame = new RestoreCommand(game);
        SaveCommand saveGame = new SaveCommand(game);
        ExitCommand exitGame = new ExitCommand(game);
        this.getBottoms().put(1, createNewGame);
        this.getBottoms().put(2, restoreGame);
        this.getBottoms().put(3, saveGame);
        this.getBottoms().put(4, exitGame);
    }
}
