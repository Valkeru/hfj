package ru.valkeru.graphic.beatbox;

import javax.sound.midi.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BeatBox {
    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;
    private static String[] instrumentNamesArray = {
            "Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare",
            "Crash Cymbal", "Hang Clap", "High Tom", "Hi Bongo",
            "Maracas", "Whistle", "Low Conga", "Cowbell",
            "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"
    };
    static ArrayList<String> instrumentNames = new ArrayList<>(Arrays.asList(instrumentNamesArray));
    private static int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    BeatBox() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buildTrack() {
        if (track != null) {
            sequence.deleteTrack(track);
        }

        track = sequence.createTrack();
        int tickCount = instrumentNamesArray.length;
        for (String instrumentName : instrumentNames) {
            int[] trackList = new int[tickCount];
            int index = instrumentNames.indexOf(instrumentName);
            int instrument = instruments[index];

            for (int j = 0; j < tickCount; j++) {
                JCheckBox checkBox = GUI.checkBoxes.get(j + (tickCount * index));
                if (checkBox.isSelected()) {
                    trackList[j] = instrument;
                } else {
                    trackList[j] = 0;
                }
            }

            makeTracks(trackList);
            track.add(Helper.makeEvent(ShortMessage.CONTROL_CHANGE, 1, 127, 0, tickCount));
        }

        track.add(Helper.makeEvent(ShortMessage.CONTROL_CHANGE, 9, 1, 0, tickCount - 1));
    }

    private void makeTracks(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int key = list[i];
            if (key != 0) {
                track.add(Helper.makeEvent(ShortMessage.NOTE_ON, 9, key, 100, i));
                track.add(Helper.makeEvent(ShortMessage.NOTE_OFF, 9, key, 100, i + 1));
            }
        }
    }

    public void play() {
        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.setTempoInBPM(120);
            sequencer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        sequencer.stop();
    }

    public void tempoUp() {
        float tempoFactor = sequencer.getTempoFactor();
        sequencer.setTempoFactor(tempoFactor * 1.03f);
    }

    public void tempoDown() {
        float tempoFactor = sequencer.getTempoFactor();
        sequencer.setTempoFactor(tempoFactor * 0.97f);
    }
}
