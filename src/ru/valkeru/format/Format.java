package ru.valkeru.format;

import java.util.Date;

public class Format {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(String.format("%tA, %1$tB %1$td", date));
    }
}
