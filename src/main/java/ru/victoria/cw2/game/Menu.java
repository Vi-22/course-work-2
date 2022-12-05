package ru.victoria.cw2.game;

import ru.victoria.cw2.command.Command;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

public class Menu {
    private String head;
    private TreeMap<Integer, Command> bottoms;
    private static final Scanner scanner = new Scanner(System.in);

    public Menu () {}
    public Menu(TreeMap<Integer, Command> bottoms) {
        setBottoms(bottoms);
    }
    public Menu(String head) {
        setHead(head);
    }
    public Menu(String head, TreeMap<Integer, Command> bottoms) {
        setBottoms(bottoms);
        setHead(head);
    }


    public boolean show() {
        System.out.println(this.head);
        Boolean isBottoms;
        try {
            bottoms.forEach((integer, bottom) -> System.out.println(integer + ". "
            +bottom.getName()));
            System.out.println("Пожалуйста, введите цифру нужного пункта меню");
            scanAnswer();
            isBottoms=true;
        }
        catch (NullPointerException e){
            System.out.println();
            System.out.println("Игра завершена!");
            System.out.println();
            isBottoms=false;
        }
        return isBottoms;
    }
    public void scanAnswer() {
       int point = 0;
        try {
            point = scanner.nextInt();
        }
        catch (InputMismatchException e) {
            point=0;
        }
        if (point > this.bottoms.size()||point<=0) exceptionHandler();
        else this.activateCommand(point);
    }
    public void exceptionHandler() {
        System.out.println("Пожалуйста, выберите нужный пункт меню.");
        scanner.nextLine();
        scanAnswer();
    }
    public void activateCommand(int command) {
        this.bottoms.get(command).execute();
    }

    public TreeMap<Integer, Command> getBottoms() {
        return bottoms;
    }

    public void setBottoms(TreeMap<Integer, Command> bottoms) {
        if (bottoms==null) throw new IllegalArgumentException();
        this.bottoms = bottoms;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        if (head==null) throw new IllegalArgumentException();
        this.head = head;
    }
    public static void closeScanner () {
        scanner.close();
    }
}
