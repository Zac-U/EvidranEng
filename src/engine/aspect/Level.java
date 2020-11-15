package engine.aspect;

import engine.core.tick;
import engine.draw.drawable;
import engine.entity.entity;
import engine.event.windowEvent;
import engine.sound.sound;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Set;

/***
 * class contains all the objects used to build a level
 * lists of collidables, moveables, drawables, player, entities
 */

public class Level implements drawable{

    speed coreSpeed = new speed();

    public sound track;

    private ArrayList<entity> elements = new ArrayList<>();

    private entity lastDrawn;

    private ArrayList<entity> mouseClicked = new ArrayList<>();

    private ArrayList<entity> keyPressed = new ArrayList<>();

    private ArrayList<entity> keyReleased = new ArrayList<>();

    private ArrayList<entity> backGround = new ArrayList<>();

    private ArrayList<entity> middleDraw = new ArrayList<>();


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

    public speed getSpeed() {return this.coreSpeed;}

    @Override
    public void draw(GraphicsContext board) {

        for (entity e: backGround) {e.draw(board);}

        for (entity e: middleDraw) {e.draw(board);}

        lastDrawn.draw(board);
    }

    public void inputEvent(windowEvent wE) {
        if(wE.getEvent().equals("MOUSECLICKED")) {
            for (entity i : mouseClicked) {i.mouseClick(wE);
            }
        }
        else if(wE.getEvent().equals("KEYPRESSED")) {
            for (entity i: keyPressed
                 ) {
                i.keyPressed(wE);
            }
        }
        else if(wE.getEvent().equals("KEYRELEASED")) {
            for (entity i: keyReleased
                 ) {
                i.keyReleased(wE);
            }
        }
    }


    public void setLastDrawn(entity e) {
        this.lastDrawn = e;
    }


    public void update(tick.game gam) {
        ArrayList<entity> stance = new ArrayList<>();
        stance.addAll(elements);
       for (entity i: stance) {i.tick(gam);}
    }

    public ArrayList<entity> getEntityList() {
        return elements;
    }

    public void addBackground(entity e) {
        backGround.add(e);
    }

    public void removeBackground(entity e) {
        backGround.remove(e);
    }

    public void addMid(entity e) { middleDraw.add(e);}

    public void removeMid(entity e){ middleDraw.remove(e);}

    public void setGameSpeed(int speed) {
        for (entity e : elements) {
            if (!e.getName().equals("Player")) {
                e.setSpeedLeft(speed * 5);
            }
        }
    }

    public class speed{
        private int speed = 5;
        public int getSpeed(){return speed;}
        public void setSpeed(int speed){this.speed = speed;}
    }

    public void stopSound() {
        if(track != null) {track.interrupt();}
    }

}
