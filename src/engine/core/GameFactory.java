package engine.core;

/***
 * Class creates a game instance by creating a thread and a window that interact with a singleton game object
 * game object has a set of stages and a current stage with a callback that passes any clicks or button presses from
 * window over to the stage
 * the loop is also given the game object so that it can tick the stages and change the stage
 */
public class GameFactory {


    public class Game implements tick.game {

    }

}
