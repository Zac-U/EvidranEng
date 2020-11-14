package engine.aspect;

import engine.draw.drawable;
import engine.entity.entity;
import engine.event.windowEvent;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;

/***
 * class contains all the objects used to build a level
 * lists of collidables, moveables, drawables, player, entities
 */

public class Level implements drawable {

    private ArrayList<entity> elements = new ArrayList<>();

    //add observer pattern for mouseclicked, keypressed, keyreleased, collision

    private ArrayList<entity> mouseClicked = new ArrayList<>();

    private ArrayList<entity> keyPressed = new ArrayList<>();

    private ArrayList<entity> keyReleased = new ArrayList<>();


    public void addEntity(entity e) {
        elements.add(e);
    }

    public void removeEntity(entity e) {elements.remove(e);}

    public void addMouseClicked(entity e) {
        mouseClicked.add(e);
    }

    public void removeMouseClicked(entity e) {
        mouseClicked.remove(e);
    }

    public void addKeyPressed(entity e) {
        keyPressed.add(e);
    }

    public void removeKeyPressed(entity e) {
        keyPressed.remove(e);
    }

    public void addKeyReleased(entity e) {
        keyReleased.add(e);
    }

    public void removeKeyReleased(entity e) {
        keyReleased.remove(e);
    }


    @Override
    public void draw(Canvas board) {
        for (entity e: elements
             ) {
            e.draw(board);
        }
    }

    public void inputEvent(windowEvent wE) {
        if(wE.getEvent().equals("MOUSECLICKED")) {
            //update mouseclicked entities
        }
        else if(wE.getEvent().equals("KEYPRESSED")) {
            //update keypressed chain
        }
        else if(wE.getKey().equals("KEYRELEASED")) {
            //update key released
        }
    }
}
