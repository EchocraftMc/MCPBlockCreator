package fr.devpioneer.mbc.frames;

import fr.devpioneer.mbc.Main;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FLogin extends JFrame {
    Logger logger = Logger.getLogger(Main.class.getName());
    public FLogin() {
        setTitle("MCB");
        setSize(640, 360);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
