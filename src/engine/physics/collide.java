package engine.physics;

import engine.component.Volume;

//POJO class for collision behaviour
public class collide extends Volume {

    public collide(int x, int y, int volx, int voly) {
        super(x,y,volx,voly);
    }

    public collide(collide c) {
        super(c.clone());
    }

    public boolean collidesWith(collide c) {
        if(this.Intersect(c)) {return true;}
        return false;
    }

    public boolean equals(collide c) {
        if(super.equals(c.clone())) {return true;}
        return false;
    }

}
