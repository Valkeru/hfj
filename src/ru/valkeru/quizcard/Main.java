package ru.valkeru.quizcard;

import java.util.ArrayList;

public class Main {
    public static ArrayList<QuizCard> cardList;
    private static GUI gui;

    public static void main(String[] args) {
        cardList = new ArrayList<>();
        gui = new GUI();
        gui.build();
    }

    public static GUI getGui() {
        return gui;
    }
}
