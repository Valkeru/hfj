package ru.valkeru.graphic.layouts;

import javax.swing.*;
import java.awt.*;

public class Main {
    static JTextArea area;

    public static void main(String[] args) {
        EventHandler handler = new EventHandler();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        area = new JTextArea(10, 20);
        area.setLineWrap(true);
        JScrollPane scroller = new JScrollPane(area);

        JPanel panel = new JPanel();
        panel.add(scroller);

        JButton button = new JButton("Клац");
        button.addActionListener(handler);
        JCheckBox checkBox = new JCheckBox("Жмяк");
        checkBox.addItemListener(handler);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        panel1.add(button);
        panel1.add(checkBox);

        String[] listEntries = {"Лиса", "Волк", "Заяц", "Медвед", "Ружжо", "Соль", "ЛОСЯША"};
        JList list = new JList(listEntries);
        list.setVisibleRowCount(3);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(handler);
        JScrollPane scroller2 = new JScrollPane(list);

        JPanel panel2 = new JPanel();
        panel2.add(scroller2);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, panel1);
        frame.getContentPane().add(BorderLayout.EAST, panel2);

        frame.setSize(350, 300);
        frame.setVisible(true);
    }
}
