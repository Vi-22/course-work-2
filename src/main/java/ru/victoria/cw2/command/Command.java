package ru.victoria.cw2.command;


public interface Command {
    void execute();

    String getName();
}