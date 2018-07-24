package ru.valkeru.files;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileWriter writer;
        try {
            writer = new FileWriter("foo.txt");
            writer.write("Hello, World");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
