package ru.valkeru.quizcard.handlers;

import ru.valkeru.quizcard.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewCardListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.cardList.clear();
        Main.getGui().clearCard();
    }
}
