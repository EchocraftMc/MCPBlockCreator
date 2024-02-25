package fr.devpioneer.mbc.frames;
import fr.devpioneer.mbc.Main;
import fr.devpioneer.mbc.panels.PCodeBlock;
import fr.devpioneer.mbc.panels.PJsonBlock;
import javax.swing.*;
import java.awt.*;

public class FHome extends JFrame {
    public FHome() {
        setTitle("MBC");
        setSize(640, 360);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setIconImage(Toolkit.getDefaultToolkit().createImage(Main.class.getClassLoader().getResource("logo.png")));

        JTabbedPane tabbedPane = new JTabbedPane();

        PJsonBlock pJsonBlock = new PJsonBlock();
        tabbedPane.add("Json for block", pJsonBlock);
        PCodeBlock pCodeBlock = new PCodeBlock();
        tabbedPane.add("Code for block", pCodeBlock);

        getContentPane().add(tabbedPane);
        setVisible(true);
    }
}


