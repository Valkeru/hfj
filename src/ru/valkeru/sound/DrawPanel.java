package ru.valkeru.sound;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel implements ControllerEventListener {
    private boolean message = false;

    @Override
    public void controlChange(ShortMessage event) {
        message = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (message) {
            g.setColor(new Color(
                    (int) (Math.random() * 255),
                    (int) (Math.random() * 255),
                    (int) (Math.random() * 255)
            ));

            g.fillRect(
                    (int) (Math.random() * 40) + 10,
                    (int) (Math.random() * 40) + 10,
                    (int) (Math.random() * 200) + 10,
                    (int) (Math.random() * 200) + 10
            );

            message = false;
        }
    }
}
