package ru.valkeru.sound;

import javax.sound.midi.*;

final class Helper {

    private Helper() {

    }

    /**
     *
     * @param command Команда. Константы из класса MidiEvent
     * @param channel Номер канала от 1 до 16
     * @param one First data byte
     * @param two Second data byte
     * @param tick Длина такта
     */
    public static MidiEvent makeEvent(int command, int channel, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(command, channel, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {
        }

        return event;
    }
}
