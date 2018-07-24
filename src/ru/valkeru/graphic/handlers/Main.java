package ru.valkeru.graphic.handlers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JLabel label;

    public static void main(String[] args) {
        Main main = new Main();
        main.go();
    }

    private void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton button = new JButton("Клац");
        button.addActionListener(new ButtonHandler());

        JButton button1 = new JButton("Label button");
        button1.addActionListener(new LabelButtonHandler());
        label = new JLabel("I'm label!");

        frame.getContentPane().add(BorderLayout.CENTER, new DrawPanel());
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.EAST, button1);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    private class LabelButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] alerts = {
                    "Чо надо?",
                    "Ты пёс",
                    "Терпеть тебя не могу",
                    "Да скройся ты нахуй!"
            };
            label.setText(alerts[(int) (Math.random() * alerts.length)]);
        }
    }
}
