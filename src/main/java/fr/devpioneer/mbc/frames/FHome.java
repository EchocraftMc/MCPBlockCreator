package fr.devpioneer.mbc.frames;


import fr.devpioneer.mbc.Main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import java.util.logging.Level;
import java.util.logging.Logger;

import static fr.devpioneer.mbc.core.BlockVariant.saveJson;

public class FHome extends JFrame {
    Logger logger = Logger.getLogger(Main.class.getName());

    public FHome() {
        setTitle("MCB");
        setSize(640, 360);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);
        logger.log(Level.INFO, "User's in the home page");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        add(panel, BorderLayout.CENTER);

        JTextField txtF = new JTextField("Block", 10);
        panel.add(txtF);

        JButton btn = new JButton("Create a new Block !");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int option = fileChooser.showSaveDialog(FHome.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File selectedDirectory = fileChooser.getSelectedFile();
                    if (selectedDirectory != null) {
                        saveJson(selectedDirectory, txtF);
                    }
                }
            }
        });
        panel.add(btn);

        logger.info("init panel");
    }
}
