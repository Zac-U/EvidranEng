package engine.physics;

import java.util.ArrayList;

//holds a list of collidable objects for levels
public class CollideList {
    private ArrayList<collide> elements = new ArrayList<collide>();

    public void add(collide c) {
        elements.add(c);
    }

    public void remove(collide c){elements.remove(c);}

    public void addList(CollideList cL){elements.addAll(cL.elements);}



}
