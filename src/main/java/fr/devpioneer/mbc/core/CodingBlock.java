package fr.devpioneer.mbc.core;

import javax.swing.*;
import java.io.*;

public class CodingBlock {
    public CodingBlock() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int option = fileChooser.showSaveDialog(null);

        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile != null) {
                String filePath = selectedFile.getAbsolutePath();
                String javaCodeToAdd = "        System.out.println(\"Inserted code\");\n";
                int lineNumberToAddCodeAfter = 5;
                try {
                    addCodeToClass(filePath, javaCodeToAdd, lineNumberToAddCodeAfter);
                    System.out.println("Code added successfully to file.");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void addCodeToClass(String filePath, String javaCodeToAdd, int lineNumberToAddCodeAfter) throws IOException {
        File file = new File(filePath);
        StringBuilder fileContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
                if (lineNumber == lineNumberToAddCodeAfter) {
                    fileContent.append(javaCodeToAdd);
                }
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(fileContent.toString());
        }
    }

    public static void main(String[] args) {
        new CodingBlock();
    }
}
