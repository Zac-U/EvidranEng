package engine.physics;

import java.util.ArrayList;

public class CollideList {
    private ArrayList<collide> elements = new ArrayList<collide>();

    public void add(collide c) {
        elements.add(c);
    }

}
