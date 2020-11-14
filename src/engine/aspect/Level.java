package engine.aspect;

import engine.entity.entity;

import java.util.ArrayList;

/***
 * class contains all the objects used to build a level
 * lists of collidables, moveables, drawables, player, entities
 */

public class Level {

    private ArrayList<entity> elements = new ArrayList<>();

    public void addEntity(entity e) {
        elements.add(e);
    }

    public void removeEntity(entity e) {elements.remove(e);}



}
