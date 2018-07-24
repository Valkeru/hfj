package ru.valkeru.graphic.beatbox;

import ru.valkeru.graphic.beatbox.handlers.StartListener;
import ru.valkeru.graphic.beatbox.handlers.StopListener;
import ru.valkeru.graphic.beatbox.handlers.TempoDownListener;
import ru.valkeru.graphic.beatbox.handlers.TempoUpListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class GUI {
    private static JFrame frame = new JFrame("BeatBox");
    static ArrayList<JCheckBox> checkBoxes = new ArrayList<>();

    static void setGui() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        BorderLayout borderLayout = new BorderLayout();
        JPanel background = new JPanel(borderLayout);
        background.setBorder(BorderFactory.createEmptyBorder());

        JButton startButton = new JButton("Запуск");
        startButton.addActionListener(new StartListener());

        JButton stopButton = new JButton("Остановить");
        stopButton.addActionListener(new StopListener());

        JButton tempUpButton = new JButton("Темп +");
        tempUpButton.addActionListener(new TempoUpListener());

        JButton tempDownButton = new JButton("Темп -");
        tempDownButton.addActionListener(new TempoDownListener());

        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        buttonBox.add(startButton);
        buttonBox.add(stopButton);
        buttonBox.add(tempUpButton);
        buttonBox.add(tempDownButton);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (String name : BeatBox.instrumentNames) {
            nameBox.add(new Label(name));
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        GridLayout layout = new GridLayout(16, 16);
        JPanel checkBoxPanel = new JPanel(layout);
        background.add(BorderLayout.CENTER, checkBoxPanel);
        for (int i = 0; i < 256; i++) {
            JCheckBox checkBox = new JCheckBox();
            checkBoxes.add(checkBox);
            checkBoxPanel.add(checkBox);
        }

        frame.getContentPane().add(background);
        frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);
    }
}
