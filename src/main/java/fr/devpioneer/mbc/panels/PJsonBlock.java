package fr.devpioneer.mbc.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static fr.devpioneer.mbc.core.BlockStates.saveJson;

public class PJsonBlock extends JPanel {
    static JMenuBar menuBar = new JMenuBar();
    public PJsonBlock() {
        setLayout(new FlowLayout());

        JTextField txtF = new JTextField("BlockName", 10);
        add(txtF);

        JButton btn = new JButton("Create Json");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int option = fileChooser.showSaveDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File selectedDirectory = fileChooser.getSelectedFile();
                    if (selectedDirectory != null) {
                        saveJson(selectedDirectory, txtF);
                    }
                }
            }
        });
        add(btn);




    }
}
