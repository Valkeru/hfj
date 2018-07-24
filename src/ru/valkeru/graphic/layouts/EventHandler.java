package ru.valkeru.graphic.layouts;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class EventHandler implements ActionListener, ItemListener, ListSelectionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.area.append("Клацнуто\n");
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox source = (JCheckBox) e.getItem();
        String state = "off";
        if (source.isSelected()) {
            state = "on";
        }

        System.out.println("Checkbox state is " + state);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        JList list = (JList) e.getSource();
        if (e.getValueIsAdjusting()) {
            String selection = (String) list.getSelectedValue();
            System.out.println(selection + " is selected");
        }
    }
}
