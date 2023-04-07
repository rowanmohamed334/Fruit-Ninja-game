package javaapplication3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.xml.bind.JAXBException;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class GamePanel extends JPanel implements ActionListener {

    ArrayList<GameObject> gameobjects = new ArrayList<>();
    ObjectMovement move = ObjectMovement.getInstance();
    File newFile = new File("savedplayer");

    Factory f = new Factory();
    Timer t = new Timer(50, this);
    MouseMove handler = MouseMove.getInstance();
    Player player = move.controller.player;
    JLabel scoreLabel = new JLabel("SCORE");
    JLabel livesLabel = new JLabel("LIVES");
    View view = new View();
    Controller controller = new Controller(player, view);
    GameFrame test;
    JFXPanel j = new JFXPanel();
    String uri = new File("Music\\Fruit-Ninja-Theme-Song.mp3").toURI().toString();
    MediaPlayer mediaPlayer = new MediaPlayer(new Media(uri));
    boolean in = false;

    public class View {

        public void ShowplayerData(int scores, int bestscore, int lives) {
            scoreLabel.setText(Integer.toString(move.controller.player.getCurrentScore()));
            livesLabel.setText(Integer.toString(move.controller.player.getLives()));
            mediaPlayer.play();
            if (move.controller.player.getLives() == 0) {
                mediaPlayer.dispose();

            }
        }
    }

    public GamePanel() {
        move.loadGame(newFile);
        move.ResetGame();
        move.saveGame();
        generateObjects();
        t.start();

        scoreLabel.setFont(scoreLabel.getFont().deriveFont(40f));
        scoreLabel.setForeground(Color.RED);
        livesLabel.setFont(scoreLabel.getFont().deriveFont(40f));
        livesLabel.setForeground(Color.BLUE);
        super.add(scoreLabel);
        super.add(livesLabel);

    }

    public void generateObjects() {

        int noofshapes;
        Random r = new Random();
        noofshapes = r.nextInt(4) + 1;
        int xloc = 200;
        int yloc = 500;
        for (int i = 0; i < noofshapes; i++) {
            GameObject g = generateRandomObject();
            g.setXLocation(xloc);
            g.setYLocation(yloc);
            gameobjects.add(g);
            if (xloc < 600) {
                xloc += 80;
            }
            move.setLevel(gameobjects);
        }
    }

    public GameObject generateRandomObject() {
        Random r = new Random();
        int x = r.nextInt(9);
        if (x == 0) {
            return f.getObject("apple");
        } else if (x == 1) {
            return f.getObject("banana");
        } else if (x == 2) {
            return f.getObject("watermelon");
        } else if (x == 3) {
            return f.getObject("bomb");

        } else if (x == 4) {
            return f.getObject("orange");
        } else if (x == 5) {
            return f.getObject("fatal bomb");

        } else if (x == 6) {
            return f.getObject("pineapple");
        } else if (x == 7) {
            return f.getObject("pome");
        } else {
            return f.getObject("dragonfruit");

        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        super.addMouseMotionListener(handler);
        Image image = new ImageIcon("Photos\\back2.png").getImage();
        g.drawImage(image, 0, 0, null);

        java.util.Iterator<GameObject> iterator = gameobjects.iterator();
        while (iterator.hasNext()) {
            GameObject go = iterator.next();
            if (!go.isSliced()) {
                g.drawImage(go.getBufferedImage().getImage(), go.getXLocation(), go.getYLocation(), this);
            } else {
                g.drawImage(go.getSlicedImage().getImage(), go.getXLocation(), go.getYLocation(), this);

            }
            move.sliceObjects(gameobjects, handler);

        }
        if (move.controller.player.getCurrentScore() < 50) {
            Image image1 = new ImageIcon("Photos\\level1.png").getImage();
            g.drawImage(image1, 0, 0, null);

        } else if (move.controller.player.getCurrentScore() >= 50 && move.controller.player.getCurrentScore() < 100) {
            Image image1 = new ImageIcon("Photos\\level2.png").getImage();
            g.drawImage(image1, 0, 0, null);

        } else {
            Image image1 = new ImageIcon("Photos\\level3.png").getImage();
            g.drawImage(image1, 0, 0, null);

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.updateObjectsLocations();
        controller.updateView();

    }

    public void updateObjectsLocations() {

        java.util.Iterator<GameObject> iterator = gameobjects.iterator();
        while (iterator.hasNext()) {
            GameObject go = iterator.next();
            if (go.isMovingUp()) {
                int oldy = go.getYLocation();
                int newy = oldy - go.getInitialVelocity();
                go.setYLocation(newy);
                if (newy < 20) {
                    go.setMovingUp(false);
                }
            } else {

                int oldy = go.getYLocation();
                int newy = oldy + go.getFallingVelocity();
                go.setYLocation(newy);
                if (newy > 500) {
                    go.setMovedOff(true);

                }

            }

        }
        boolean alloffscreen = true;
        for (int i = 0; i < gameobjects.size(); i++) {
            GameObject go = gameobjects.get(i);
            if (!go.hasMovedOffScreen()) {
                alloffscreen = false;
                break;
            }
        }

        if (alloffscreen) {
            gameobjects.clear();
            generateObjects();

        }
        repaint();

    }

}
