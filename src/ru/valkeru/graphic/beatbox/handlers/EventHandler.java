package ru.valkeru.graphic.beatbox.handlers;

import ru.valkeru.graphic.beatbox.BeatBox;

public class EventHandler {
    static BeatBox beatBox;

    public static void setBeatBox(BeatBox beatBox) {
        EventHandler.beatBox = beatBox;
    }
}
