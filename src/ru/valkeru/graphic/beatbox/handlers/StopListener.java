package ru.valkeru.graphic.beatbox.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopListener extends EventHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        beatBox.stop();
    }
}
