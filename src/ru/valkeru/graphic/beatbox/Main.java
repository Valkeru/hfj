package ru.valkeru.graphic.beatbox;

import ru.valkeru.graphic.beatbox.handlers.EventHandler;

public class Main {
    public static void main(String[] args) {
        EventHandler.setBeatBox(new BeatBox());
        GUI.setGui();
    }
}
