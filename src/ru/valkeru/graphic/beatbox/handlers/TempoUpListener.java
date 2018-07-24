package ru.valkeru.graphic.beatbox.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TempoUpListener extends EventHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        beatBox.tempoUp();
    }
}
