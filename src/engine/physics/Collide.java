package engine.physics;

import engine.component.Volume;
import engine.entity.entity;
import engine.event.collisionEvent;

import java.util.ArrayList;

//POJO class for collision behaviour
public class Collide extends Volume {

    public Collide(int x, int y, int volx, int voly) {
        super(x,y,volx,voly);
    }

    public Collide(Collide c) {
        super(c.clone());
    }

    public boolean collidesWith(Collide c) {
        if(this.equals(c) || this.getName().equals(c.getName())) {

            return false;
        }
        if(this.Intersect(c) || c.Intersect(this)) {return true;}
        return false;
    }

    public boolean collidesWithEx(Collide c) {
        if(this.equals(c)) {
            return false;
        }
        if(this.IntersectEx(c) || c.IntersectEx(this)) {return true;}
        return false;
    }

    //public collisionEvent collidesWith(ArrayList<entity> list) {
       // for (entity ent: list) {
           // if(this.collidesWith(ent))
        //}
    //}

    public boolean equals(Collide c) {
        if(this.getX() == c.getX() && this.getY() == c.getY() && this.getVolX()==c.getVolX() && this.getVolY() == c.getVolY()) {return true;}
        return false;
    }

    public Collide clone() {
        return new Collide(this.getX(),this.getY(),this.getVolX(),this.getVolY());
    }

    public Volume getVolume() {return super.clone();}

    protected void setMomento(Collide c) {
        super.setMomento(c.getVolume());
    }

    public Collide get(){return this;}

}
