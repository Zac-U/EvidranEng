package engine.core;

import engine.aspect.Stage;
import engine.entity.entity;
import engine.event.event;
import engine.event.windowEvent;
import javafx.scene.canvas.Canvas;

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

        @Override
        public void passInputEvent(windowEvent e) {
            currentStage.sendInput(e);
        }

        @Override
        public void update() {
            currentStage.update(this);
        }

        @Override
        public void draw(java.awt.Canvas board) {
        }

        @Override
        public Set<entity> getEntityList() {
            return currentStage.getEntityList();
        }

        @Override
        public void draw(Canvas board) {
            currentStage.draw(board);
        }
    }

}
