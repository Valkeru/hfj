package ru.valkeru.sound;

import javax.sound.midi.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        player.setUpGui();
        player.play();
    }
}
