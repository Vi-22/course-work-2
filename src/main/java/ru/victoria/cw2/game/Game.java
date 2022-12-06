package ru.victoria.cw2.game;

import ru.victoria.cw2.scenario.Paragraph;
import ru.victoria.cw2.scenario.Scenario;
import ru.victoria.cw2.services.SaveManager;

public class Game {
    private Paragraph currentParagraph;

    public Game() {}

    public void run(){
        this.standartMainMenu();
    }
    public void standartMainMenu() {
        MainMenu mainMenu = new MainMenu();
        mainMenu.setStandartMainMenu(this);
        mainMenu.show();
    }
    public void extendMainMenu() {
        MainMenu mainMenu = new MainMenu();
        mainMenu.setExtendMainMenu(this);
        mainMenu.show();
    }
    public void gameMenu() {
        GameMenu gameMenu = new GameMenu();
        gameMenu.setGameMenu(this);
        if (!gameMenu.show()) standartMainMenu();
    }
    public void createNew(){
        this.currentParagraph = Scenario.startScenario();
        gameMenu();
    }
    public void restore(){
        this.currentParagraph = SaveManager.restoreGame();
        gameMenu();
    }
    public void exit(){
        MainMenu.closeScanner();
        System.out.println("Вы вышли из игры!");
        System.exit(200);
    }
    public void save(){
        SaveManager.saveGame(this.currentParagraph);
        MainMenu mainMenu = new MainMenu();
        mainMenu.setStandartMainMenu(this);
        mainMenu.show();
    }
    public void firstAction() {
        this.currentParagraph = (Scenario.nextParagraph(this.currentParagraph, 0));
        gameMenu();
    }
    public void secondAction() {
        this.currentParagraph = (Scenario.nextParagraph(this.currentParagraph,1));
        gameMenu();
    }

    public Paragraph getCurrentParagraph() {
        return currentParagraph;
    }

    public void setCurrentParagraph(Paragraph currentParagraph) {
        if (currentParagraph==null) throw new IllegalArgumentException();
        this.currentParagraph = currentParagraph;
    }
}
