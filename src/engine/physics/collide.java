package engine.physics;

import engine.Volume;

public class collide extends Volume {

    public collide(int x, int y, int volx, int voly) {
        super(x,y,volx,voly);
    }

    public boolean collidesWith(collide c) {
        if(this.Intersect(c)) {return true;}
        return false;
    }

}
