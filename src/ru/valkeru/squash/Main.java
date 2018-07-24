package ru.valkeru.squash;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Cat cat = new Cat();
        cat.hasTail = false;

        FileOutputStream fileOutputStream = new FileOutputStream("serial.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(cat);
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("serial.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object o = objectInputStream.readObject();
        objectInputStream.close();

        Thread.sleep(1);
    }
}
