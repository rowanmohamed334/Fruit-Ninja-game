package javaapplication3;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class WelcomePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon("Photos\\logo-fruit-ninja.jpg").getImage();
        g.drawImage(image, 0, 0, null);
    }
}
