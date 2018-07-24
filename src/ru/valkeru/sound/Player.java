package ru.valkeru.sound;

import javax.sound.midi.*;
import javax.swing.*;

class Player {
    private static JFrame mainWindow = new JFrame("Какая-то дичь");
    private static DrawPanel visualization;

    void setUpGui() {
        visualization = new DrawPanel();
        mainWindow.setContentPane(visualization);
        mainWindow.setBounds(30, 30, 300, 300);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);
    }

    void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            int[] wantedEvents = {127};
            sequencer.addControllerEventListener(visualization, wantedEvents);

            for (int i = 5; i < 120; i++) {
                track.add(Helper.makeEvent(ShortMessage.NOTE_ON, 1, i, 100, i));
                track.add(Helper.makeEvent(ShortMessage.CONTROL_CHANGE, 1, 127, 0, i));
                track.add(Helper.makeEvent(ShortMessage.NOTE_OFF, 1, i, 100, i + 2));
            }

            sequencer.setSequence(sequence);
            sequencer.setTempoInBPM(220);
            sequencer.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
