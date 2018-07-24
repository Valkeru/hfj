package ru.valkeru.graphic.animation;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(Color.GREEN);
        g.fillOval(SimpleAnimation.x, SimpleAnimation.y, 40, 40);
    }
}
