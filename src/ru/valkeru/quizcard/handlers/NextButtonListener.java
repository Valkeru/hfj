package ru.valkeru.quizcard.handlers;

import ru.valkeru.quizcard.Main;
import ru.valkeru.quizcard.QuizCard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String question = Main.getGui().getQuestionText();
        String answer = Main.getGui().getAnswerText();
        QuizCard card = new QuizCard(question, answer);
        Main.cardList.add(card);
        Main.getGui().clearCard();
    }
}
