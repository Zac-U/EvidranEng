package engine.physics;

import java.util.ArrayList;

//holds a list of collidable objects for levels
public class CollideList {
    private ArrayList<Collide> elements = new ArrayList<Collide>();

    public void add(Collide c) {
        elements.add(c);
    }

    public void remove(Collide c){elements.remove(c);}

    public void addList(CollideList cL){elements.addAll(cL.elements);}

    public boolean collides(Collide c) {
        for (Collide col: elements
             ) {
            if(col.collidesWith(c)) {return true;}
        }
        return false;
    }

}
