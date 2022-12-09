package ru.victoria.cw2.services;

import ru.victoria.cw2.scenario.Paragraph;

public class SaveManager {
    private static final FileManager <Paragraph> fileManager =
            new FileManager<>(ConfigurationManager.getProperty("SAVER_URL"));

    public static void saveGame(Paragraph paragraph) {
        fileManager.writeToFile(paragraph);
        System.out.println("Игра успешно сохранена!");
    }
    public static Paragraph restoreGame() {
        return fileManager.readFromFile();
    }
}
