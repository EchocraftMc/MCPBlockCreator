package fr.devpioneer.mbc;

import com.formdev.flatlaf.FlatDarkLaf;
import fr.devpioneer.mbc.gui.frames.FHome;


import javax.swing.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws IOException {
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            logger.warning("Failed to initialize LaF" );
        }
        FHome fHome = new FHome();
        logger.log(Level.INFO, "App launched correctly !");
    }
}