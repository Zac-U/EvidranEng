package engine.aspect;

import engine.component.Volume;
import engine.core.tick;
import engine.draw.drawable;
import engine.entity.entity;
import engine.event.windowEvent;
import javafx.scene.canvas.Canvas;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Set;

/***
 * A Stage is an aspect of a game, basicaly a screen, whether that's the menu or the level
 * it has a set of buttons and a set of levels
 * also has a level frame which is an object that holds a level and all it's associated objects
 */
public class Stage implements drawable{

    ArrayList<Button> buttons;
    Level level;
    String name;

    @Override
    public void draw(Canvas board) {
        for (Button b: buttons
             ) {
            b.draw(board);
        }
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

    public Set<entity> getEntityList() {
        return level.getEntityList();
    }

    public Level getLevel() {return level;}

    public void setLevel(Level L) {
        level = L;
    }

}
