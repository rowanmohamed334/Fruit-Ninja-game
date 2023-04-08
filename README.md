# Fruit Ninja Game Clone
## ScreenShots


![Screenshot 2023-04-08 194402](https://user-images.githubusercontent.com/74663172/230735994-10906722-d9e1-4248-bfed-243ee24cd1ce.png)
![Screenshot 2023-04-08 194442](https://user-images.githubusercontent.com/74663172/230735998-21b60645-0aa5-4c1f-8d03-6240323d095d.png)
![Screenshot 2023-04-08 194503](https://user-images.githubusercontent.com/74663172/230736002-fb60c88a-dd1e-4fa9-b543-e982b7f36c36.png)

## User Guide
The game starts by a welcome window where the user has to click on
(Start Game) button to start playing .
- By doing so , he will be navigated to the game frame where the game
starts .
- Each player has initially 3 lives and score set to zero which are
updated on the screen through the red and blue labels which
represent the score and lives respectively .
- The player attempts to slice the fruits and increase his score by simply
moving the mouse on the required fruit.
- By slicing special fruits represented in pomegranate and dragonfruit ,
the player adds 5 points to his score rather than 1 point which is
added when he slices normal fruits .
- The player gets to level 2 when his score reaches 50 points and level 3
on reaching 100 points .
- In each level , the fruit’s speed increases to make the game more
challenging .
- The player loses the game by either losing all his lives or by slicing a
fatal bomb and by this , he will be navigated to another frame where
he can preview his score in each round and the best score he achieved
while playing .
- To start a new round , the player has to click on (back ) button and he
will be navigated to the welcome frame again .
- Each new round resets the player’s score to 0 and his lives to 3 .

## Game Design
### The game’s design is represented as follows :
- The player represents a singleton who is responsible for slicing objects
and gaining points which are recorded in each round using the
Memento​ design pattern .
- The sliced objects which are normal fruits , special fruits and bombs
are represented as classes that all implement the abstract class
Game Object ​and are generated using​ Factory​ design pattern .
- The game’s levels vary according to the player’s score , when his score
exceeds a certain number , he goes to a higher level with the help of
State​ design pattern .
- The player’s data is all saved to an xml file through​ XMLReadSave
class .
- The movement of game objects on screen is controlled by
objectMovement ​class which implements ​GameActions​ interface .
- The MVC is represented by a​ Model ​which is recorded as the​ Player
class , ​Controller​ which is responsible for managing the player’s data
and the ​View ​represented in the GamePanel for previewing the
player’s score.
- The GUI is represented in 3 frames :
  1. WelcomeFrame ​which appears which leads to the game .
  2. GameFrame ​which includes the ​GamePanel​ “where the game
  takes place “.
  3. GameOverFrame ​which appears when the player loses and
displays his score.

## Design Patterns
### The game supports five design patterns which serve the application’s design :

1. Singleton Pattern :
  This pattern is concerned with the ​Player​ class and ​MouseMove​ class
  as the game supports single player only .
2. Iterator Pattern :
  This pattern is mainly used to loop over arraylists of (GameObject)
  type instead of using ​for​ loops all over the application .
3. State Pattern :
  This pattern serves the required game levels , it switches to the
  required level according to the player’s score which is passed as an
  argument .
4. Memento Pattern :
  This pattern is used to record the player’s score in each round and
  display it by iterating over the memento list and restoring all of its
  elements during run-time .
5. Factory Pattern :
  This pattern is concerned with generating objects and adding them to
  an arraylist .It generates the object according to the object name
  passed as an argument. 
