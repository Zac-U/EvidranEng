package engine.physics;

import engine.component.Volume;

//POJO class for collision behaviour
public class Collide extends Volume {

    public Collide(int x, int y, int volx, int voly) {
        super(x,y,volx,voly);
    }

    public Collide(Collide c) {
        super(c.clone());
    }

    public boolean collidesWith(Collide c) {
        if(this.Intersect(c)) {return true;}
        return false;
    }

    public boolean equals(Collide c) {
        if(super.equals(c.clone())) {return true;}
        return false;
    }

    public Collide clone() {
        return new Collide(this.getX(),this.getY(),this.getVolX(),this.getVolY());
    }

    public Volume getVolume() {return super.clone();}

    protected void setMomento(Collide c) {
        super.setMomento(c.getVolume());
    }

}
