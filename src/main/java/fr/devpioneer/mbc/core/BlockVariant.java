package fr.devpioneer.mbc.core;

import com.google.gson.Gson;
import fr.devpioneer.mbc.frames.FHome;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BlockVariant {
    private Map<String, Map<String, String>> variants;

    public BlockVariant(Map<String, Map<String, String>> variants) {
        this.variants = variants;
    }

    public Map<String, Map<String, String>> getVariants() {
        return variants;
    }

    public void setVariants(Map<String, Map<String, String>> variants) {
        this.variants = variants;
    }

    public static void saveJson(File selectedDirectory, JTextField txtF) {
        try {
            final String blockName = txtF.getText();
            Map<String, String> modelMap = new HashMap<>();
            modelMap.put("model", blockName);

            Map<String, Map<String, String>> variantsMap = new HashMap<>();
            variantsMap.put("normal", modelMap);

            BlockVariant blockVariant = new BlockVariant(variantsMap);

            Gson gson = new Gson();
            File json = new File(selectedDirectory.getAbsolutePath() + "/" + blockName + ".json");
            if (!json.exists()){
                json.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(json));
            writer.write(gson.toJson(blockVariant));
            writer.close();
            JOptionPane.showMessageDialog(null, "File saved successfully!");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
