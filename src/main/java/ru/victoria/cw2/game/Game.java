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
        mainMenu.set(this);
        mainMenu.show();
    }
    public void extendMainMenu() {
        MainMenu mainMenu = new MainMenu();
        mainMenu.extend(this);
        mainMenu.show();
    }
    public void gameMenu() {
        GameMenu gameMenu = new GameMenu();
        gameMenu.set(this);
        if (!gameMenu.show()) standartMainMenu();
    }
    public void createNew(){
        setCurrentParagraph(Scenario.startScenario());
        gameMenu();
    }
    public void restore(){
        setCurrentParagraph(SaveManager.restoreGame());
        gameMenu();
    }
    public void exit(){
        MainMenu.closeScanner();
        System.out.println("Вы вышли из игры!");
        System.exit(200);
    }
    public void save(){
        SaveManager.saveGame(getCurrentParagraph());
        MainMenu mainMenu = new MainMenu();
        mainMenu.set(this);
        mainMenu.show();
    }
    public void firstAction() {
        setCurrentParagraph(Scenario.nextParagraph(getCurrentParagraph(), 0));
        gameMenu();
    }
    public void secondAction() {
        setCurrentParagraph(Scenario.nextParagraph(getCurrentParagraph(),1));
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
