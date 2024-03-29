package fr.devpioneer.mbc.core.json;

import com.google.gson.Gson;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BlockStates {
    private Map<String, Map<String, String>> variants;

    public BlockStates(Map<String, Map<String, String>> variants) {
        this.variants = variants;
    }

    public Map<String, Map<String, String>> getVariants() {
        return variants;
    }

    public void setVariants(Map<String, Map<String, String>> variants) {
        this.variants = variants;
    }

    public static void saveStatesJson(File selectedDirectory, String txtF) {
        try {
            final String blockName = txtF;
            Map<String, String> modelMap = new HashMap<>();
            modelMap.put("model", blockName);

            Map<String, Map<String, String>> variantsMap = new HashMap<>();
            variantsMap.put("normal", modelMap);

            BlockStates blockStates = new BlockStates(variantsMap);

            Gson gson = new Gson();
            File directory = new File(selectedDirectory.getAbsolutePath());
            File json = new File(directory.getAbsolutePath() +"/" + blockName + ".json");
            if (!json.exists()){
                directory.mkdir();
                json.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(json));
            writer.write(gson.toJson(blockStates));
            writer.close();
            JOptionPane.showMessageDialog(null, "File saved successfully!");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
