package fr.devpioneer.mbc.gui.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class PCodeBlock extends JPanel {
    public PCodeBlock() {
        setLayout(new FlowLayout());


        JTextField txtF = new JTextField("BlockName", 10);
        add(txtF);

        JButton btn = new JButton("Create Block");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("test");

            }
        });
        add(btn);

    }

}
