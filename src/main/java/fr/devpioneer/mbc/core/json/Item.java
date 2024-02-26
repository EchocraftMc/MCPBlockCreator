package fr.devpioneer.mbc.core.json;

import com.google.gson.Gson;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Item {
    private String parent;
    private Map<String, Map<String, List<Double>>> display;

    public Item(String parent, Map<String, Map<String, List<Double>>> display) {
        this.parent = parent;
        this.display = display;
    }

    public static void saveItemJson(File selectedDirectory, String blockName) throws IOException {
        try {
            String parent = "block/" + blockName;
            Map<String, List<Double>> thirdPersonProps = new HashMap<>();
            thirdPersonProps.put("rotation", Arrays.asList(10.0, -45.0, 170.0));
            thirdPersonProps.put("translation", Arrays.asList(0.0, 1.5, -2.75));
            thirdPersonProps.put("scale", Arrays.asList(0.375, 0.375, 0.375));

            Map<String, Map<String, List<Double>>> displayProps = new HashMap<>();
            displayProps.put("thirdperson", thirdPersonProps);

            Item item = new Item(parent, displayProps);


            Gson gson = new Gson();
            File directory = new File(selectedDirectory.getAbsolutePath());
            File json = new File(directory.getAbsolutePath() + "/" + blockName + ".json");
            if (!json.exists()) {
                directory.mkdir();
                json.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(json));
            writer.write(gson.toJson(item));
            writer.close();
            JOptionPane.showMessageDialog(null, "File saved successfully!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}