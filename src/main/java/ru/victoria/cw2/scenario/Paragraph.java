package ru.victoria.cw2.scenario;

import java.io.Serializable;
import java.util.List;

public class Paragraph implements Serializable {
    private String title;
    private String text;
    private List<String> actions;
    private List<String> next;

    private Paragraph(){}
    private Paragraph(String title, String text) {
        setTitle(title);
        setText(text);
        this.actions = null;
        this.next = null;
    }

    private Paragraph(String title, String text, List<String> actions) {
        setTitle(title);
        setText(text);
        setActions(actions);
        this.next = null;
    }

    private Paragraph(String title, String text, List<String> actions, List<String> next) {
        setTitle(title);
        setText(text);
        setActions(actions);
        setNext(next);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title==null) throw new IllegalArgumentException();
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (text==null) throw new IllegalArgumentException();
        this.text = text;
    }

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }

    public List<String> getNext() {
        return next;
    }

    public void setNext(List<String> next) {
        this.next = next;
    }
    @Override
        public String toString () {
            return "\nTitle: " + title + "\nText: " + text;
        }
}

