package ru.valkeru.graphic.handlers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String[] alerts = {
                "Клац",
                "Я клацнуто",
                "Жми-жми...",
                "Тебе заняться нечем?",
                "Ты - хуй",
                "Вали отсюда!"
        };
        button.setText(alerts[(int) (Math.random() * alerts.length)]);

        JFrame frame = (JFrame) button.getParent().getParent().getParent().getParent();
        frame.repaint();

        try {
            Thread.sleep(2);
        } catch (InterruptedException ex) {

        }
    }
}
