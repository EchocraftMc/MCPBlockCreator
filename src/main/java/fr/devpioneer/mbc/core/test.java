package fr.devpioneer.mbc.core;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        // Création de la structure de données
        Map<String, String> modelMap = new HashMap<>();
        modelMap.put("model", "cobblestone");

        Map<String, Map<String, String>> variantsMap = new HashMap<>();
        variantsMap.put("normal", modelMap);

        BlockVariant blockVariant = new BlockVariant(variantsMap);

        // Utilisation de Gson pour convertir l'objet en JSON
        Gson gson = new Gson();
        String json = gson.toJson(blockVariant);

        // Affichage du JSON
        System.out.println(json);
    }
}
