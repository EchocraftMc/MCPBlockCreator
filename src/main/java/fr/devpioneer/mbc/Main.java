package fr.devpioneer.mbc;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.google.gson.Gson;
import fr.devpioneer.mbc.core.Block;
import fr.devpioneer.mbc.core.BlockVariant;
import fr.devpioneer.mbc.frames.FHome;
import fr.devpioneer.mbc.frames.FLogin;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws IOException {
        //TODO: Launch the frame
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            logger.warning( "Failed to initialize LaF" );
        }
        FHome fHome = new FHome();
        logger.log(Level.INFO, "App launched correctly !");
    }
}