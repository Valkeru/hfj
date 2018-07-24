package ru.valkeru.quizcard.handlers;

import ru.valkeru.quizcard.Main;
import ru.valkeru.quizcard.QuizCard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveCardListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String question = Main.getGui().getQuestionText();
        String answer = Main.getGui().getAnswerText();
        if (!question.isEmpty() && !answer.isEmpty()) {
            QuizCard card = new QuizCard(question, answer);
            Main.cardList.add(card);
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showSaveDialog(Main.getGui().getFrame());
        saveFile(fileChooser.getSelectedFile());
    }

    private void saveFile(File file) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (QuizCard card: Main.cardList) {
                writer.write(card.getQuestion() + "/");
                writer.write(card.getAnswer() + "\n");
            }
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
