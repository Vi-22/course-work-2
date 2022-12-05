package ru.victoria.cw2.services;

import java.io.*;

public class FileManager<T> {
    public String file;
    public FileManager(String fileName) {
        setFile(fileName);
    }
    public void writeToFile(T object) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(getFile());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public T readFromFile () {
        try {
            FileInputStream fileInputStream = new FileInputStream(getFile());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (T) objectInputStream.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
