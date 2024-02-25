package fr.devpioneer.mbc.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static fr.devpioneer.mbc.core.Block.saveBlockJson;
import static fr.devpioneer.mbc.core.BlockStates.saveStatesJson;
import static fr.devpioneer.mbc.core.Item.saveItemJson;

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
                        try {
                            File directoryBlockstates = new File(selectedDirectory.getAbsolutePath() + "/MBC/Blockstates/");
                            File directoryModel = new File(selectedDirectory.getAbsolutePath() + "/MBC/Models");
                            File directoryBlock = new File(selectedDirectory.getAbsolutePath() + "/MBC/Models/Blocks");
                            File directoryItems = new File(selectedDirectory.getAbsolutePath() + "/MBC/Models/Items");

                            if (!directoryBlock.exists() || !directoryItems.exists() || !directoryModel.exists() || !directoryBlockstates.exists()){
                                directoryItems.mkdirs();
                                directoryBlock.mkdirs();
                                directoryModel.mkdirs();
                                directoryBlockstates.mkdirs();
                            }
                            saveItemJson(directoryItems, txtF);
                            saveBlockJson(directoryBlock, txtF);
                            saveStatesJson(directoryBlockstates, txtF);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });
        add(btn);




    }
}
