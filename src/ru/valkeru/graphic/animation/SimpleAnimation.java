package ru.valkeru.graphic.animation;

import javax.swing.*;

public class SimpleAnimation {
    static int x = 70;
    static int y = 70;

    public static void main(String[] args) throws InterruptedException {
        SimpleAnimation app = new SimpleAnimation();
        app.go();
    }

    private void go() throws InterruptedException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        DrawPanel drawPanel = new DrawPanel();

        frame.getContentPane().add(drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);

        for (int i = 0; i < 130; i++) {
            x++;
            y++;

            drawPanel.repaint();
            Thread.sleep(5);
        }
    }
}
