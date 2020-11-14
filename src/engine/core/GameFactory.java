package engine.core;

import engine.aspect.Stage;
import engine.event.event;

import java.util.ArrayList;
import java.util.Set;

/***
 * Class creates a game instance by creating a thread and a window that interact with a singleton game object
 * game object has a set of stages and a current stage with a callback that passes any clicks or button presses from
 * window over to the stage
 * the loop is also given the game object so that it can tick the stages and change the stage
 */
public class GameFactory {


    public class Game implements tick.game {

        //core game loop
        //window
        Stage currentStage;
        ArrayList<Stage> elements;

        public void visit(event e) {
            e.visit(this);
        }

        @Override
        public Stage getCurrentStage() {
            return currentStage;
        }

        @Override
        public Set<Stage> getSetList() {
            return (Set<Stage>) elements;
        }

        @Override
        public void setCurrentStage(Stage s) {
            this.currentStage = s;
        }

        @Override
        public void addStage(Stage s) {
            elements.add(s);
        }
    }

}
