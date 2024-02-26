package fr.devpioneer.mbc;

import com.formdev.flatlaf.FlatDarkLaf;
import fr.devpioneer.mbc.gui.frames.FHome;


import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static fr.devpioneer.mbc.core.json.Block.saveBlockJson;
import static fr.devpioneer.mbc.core.json.BlockStates.saveStatesJson;
import static fr.devpioneer.mbc.core.json.Item.saveItemJson;

public class Main {
    public static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws IOException {
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            logger.warning("Failed to initialize LaF" );
        }
        if (args.length > 0 && args[0].equals("-nogui")) {
            Scanner scn = new Scanner(System.in);
            System.out.println("json or code ?");
            String strScnJson = scn.nextLine();
            if (strScnJson != null && strScnJson.equals("json")) {
                Scanner scnPath = new Scanner(System.in);
                System.out.println("Enter the entire path :");
                String strPath = scnPath.nextLine();
                if (strPath != null) {
                    File path = new File(strPath);

                    File directoryBlockstates = new File(path.getAbsolutePath() + "/MBC/Blockstates/");
                    File directoryModel = new File(path.getAbsolutePath() + "/MBC/Models");
                    File directoryBlock = new File(path.getAbsolutePath() + "/MBC/Models/Blocks");
                    File directoryItems = new File(path.getAbsolutePath() + "/MBC/Models/Items");

                    if (!directoryBlock.exists() || !directoryItems.exists() || !directoryModel.exists() || !directoryBlockstates.exists()){
                        directoryItems.mkdirs();
                        directoryBlock.mkdirs();
                        directoryModel.mkdirs();
                        directoryBlockstates.mkdirs();
                    }

                    saveItemJson(directoryItems, args[1]);
                    saveBlockJson(directoryBlock, args[1]);
                    saveStatesJson(directoryBlockstates, args[1]);
                    logger.info("Jsons saved ! ");
                }
            }
        } else {
            new FHome();
        }
        logger.log(Level.INFO, "App launched correctly !");
    }
}