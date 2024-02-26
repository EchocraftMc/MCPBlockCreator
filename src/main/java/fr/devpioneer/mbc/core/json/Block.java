package fr.devpioneer.mbc.core.json;

import com.google.gson.Gson;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Block {
    private String parent;
    private Map<String, String> textures;

    public Block(String parent, Map<String, String> textures) {
        this.parent = parent;
        this.textures = textures;
    }
    public static void saveBlockJson(File selectedDirectory, String blockName) {
        try {
            String parent = "block/cube_all";
            String texturePath = "blocks/" + blockName;


            Map<String, String> textures = new HashMap<>();
            textures.put("all", texturePath);
            Block block = new Block(parent, textures);


            Gson gson = new Gson();
            File directory = new File(selectedDirectory.getAbsolutePath() );
            File json = new File(directory.getAbsolutePath() + "/" + blockName + ".json");
            if (!json.exists()){
                directory.mkdir();
                json.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(json));
            writer.write(gson.toJson(block));
            writer.close();
            JOptionPane.showMessageDialog(null, "File saved successfully!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}
