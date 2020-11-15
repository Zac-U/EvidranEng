package engine.aspect;

import engine.component.Volume;
import engine.core.tick;
import engine.draw.drawable;
import engine.entity.entity;
import engine.event.windowEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Set;

/***
 * A Stage is an aspect of a game, basicaly a screen, whether that's the menu or the level
 * it has a set of buttons and a set of levels
 * also has a level frame which is an object that holds a level and all it's associated objects
 */
public class Stage implements drawable{

    Level level;
    String name;

    @Override
    public void draw(GraphicsContext board) {

        level.draw(board);
    }

    public Stage(String name) {
        this.name = name;
    }

    public void sendInput(windowEvent e) {
        level.inputEvent(e);
    }

    public void update(tick.game gam){
        level.update(gam);
    }

    public ArrayList<entity> getEntityList() {
        return level.getEntityList();
    }

    public Level getLevel() {return level;}

    public void setLevel(Level L) {
        level = L;
    }

    public void setGameSpeed(int speed) { level.setGameSpeed(speed); }

}
