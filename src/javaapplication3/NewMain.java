package javaapplication3;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class NewMain {
  public static void playMusic(String path) 
    {
        InputStream music;
        try{
        music = new FileInputStream(new File(path));
        AudioStream audios = new AudioStream(music);
        AudioPlayer.player.start(audios);
    }
        catch(Exception e){
        }
    }
    public static void main(String[] args) {
          playMusic("Music\\\\Fruit-Ninja-Theme-Song.mp3");
    }
}
