package ru.victoria.cw2.scenario;

import ru.victoria.cw2.services.ConfigurationManager;

import java.util.List;


public class Scenario {
    private static List<Paragraph> paragraphList;

    static {
        setParagraphList();
    }

    public static Paragraph startScenario() {
        return paragraphList.get(0);
    }

    public static Paragraph nextParagraph(Paragraph currentParagraph, int number) {
        String nextParagraphName = currentParagraph.getNext().get(number);
        Paragraph nextParagraph = null;
        for (Paragraph paragraph : paragraphList) {
            if (paragraph.getTitle().equals(nextParagraphName))
                nextParagraph = paragraph;
        }
        return nextParagraph;
    }

    public static List<Paragraph> getParagraphList() {
        return paragraphList;
    }

    private static void setParagraphList() {
        Scenario.paragraphList = ConfigurationManager.getScenarioConfiguration();
    }
}


