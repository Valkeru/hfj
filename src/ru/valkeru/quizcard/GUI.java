package ru.valkeru.quizcard;

import ru.valkeru.quizcard.handlers.NewCardListener;
import ru.valkeru.quizcard.handlers.NextButtonListener;
import ru.valkeru.quizcard.handlers.SaveCardListener;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private JTextArea question;
    private JTextArea answer;
    private JFrame frame;

    void build() {
        frame = new JFrame("Quiz card builder");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        Font font = new Font("sanserif", Font.BOLD, 24);
        question = new JTextArea(6, 20);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(font);

        JScrollPane qScroll = new JScrollPane(question);
        qScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        answer = new JTextArea(6, 20);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(font);

        JScrollPane aScroll = new JScrollPane(answer);
        aScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JButton next = new JButton("Next");
        next.addActionListener(new NextButtonListener());
        JLabel qlabel = new JLabel("Question");
        JLabel alabel = new JLabel("Answer");

        mainPanel.add(qlabel);
        mainPanel.add(qScroll);
        mainPanel.add(alabel);
        mainPanel.add(aScroll);
        mainPanel.add(next);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        newMenuItem.addActionListener(new NewCardListener());
        saveMenuItem.addActionListener(new SaveCardListener());
        menu.add(newMenuItem);
        menu.add(saveMenuItem);
        menuBar.add(menu);

        frame.setJMenuBar(menuBar);
        frame.add(BorderLayout.CENTER, mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public String getQuestionText() {
        return question.getText();
    }

    public String getAnswerText() {
        return answer.getText();
    }

    public JFrame getFrame() {
        return frame;
    }

    public void clearCard() {
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }
}
