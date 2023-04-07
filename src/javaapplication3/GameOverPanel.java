package javaapplication3;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class GameOverPanel extends  JPanel{
       @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon("Photos\\back.png").getImage();
        g.drawImage(image, 0, 0, null);
    }
}
