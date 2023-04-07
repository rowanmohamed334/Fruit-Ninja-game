
package javaapplication3;

import java.util.ArrayList;


public class Level {
     private int score;
    private LevelState levelstate;
   
    public Level(int score) {
        this.setScore(score);
    }

    public void velocity(ArrayList gameobjects) {
        levelstate.velocity(gameobjects);
    }

  

    public void setScore(int score) {
        this.score = score;

        if (score >= 50 && score<100) {

            levelstate = new Level2();
        }
        else if (score >= 100) {
            levelstate = new Level3();
            
        }
        else  if (score <50) {
            levelstate = new Level1();
        }
      
    }
  
}
