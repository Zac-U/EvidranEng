package engine.physics;

import engine.entity.entity;
import engine.event.collisionEvent;

import java.util.Set;

//class describes objects that can move
public class Moveable extends Collide {

    Moveable momento;

    private int[] speed = new int[4];

    private boolean collider = true;

    public Moveable(int x, int y, int volx, int voly) {
        super(x,y,volx,voly);
        for(int i =0; i < speed.length; i++) {speed[i] = 0;}
    }

    public Moveable(Moveable m) {
        super(m.getCollide());
        for(int i =0; i < this.speed.length; i++) {this.speed[i] = m.speed[i];}
        }


    public Collide getCollide() {
        return super.clone();
    }

    public void setCollider(boolean b) {collider = b;}

    private void Move(int i) {
        if(i == 0) {this.addX(-speed[i]);}
        else if(i == 1) { this.addY(speed[i]);}
        else if(i == 2) {this.addX(speed[i]);}
        else if(i == 3) {this.addY(-speed[i]);}
    }

    public collisionEvent createEvent(entity e, int i) {
        if(i == 0) {return new collisionEvent(e, "UP");}
        else if(i == 1) {return new collisionEvent(e, "RIGHT");}
        else if(i == 2) {return new collisionEvent(e, "LEFT");}
        else if(i == 3) {return new collisionEvent(e, "DOWN");}
        return null;
    }

    public collisionEvent move(Set<entity> elements) {
           //for every direction this object tries to move
        for (int i = 0; i < speed.length ; i++) {
            this.saveMomento();//save a momento
            for (entity e: elements
                 ) {
                if(e.collidesWith(this.getCollide())) {
                    return createEvent(e, i);
                }
            }

        }
        return null;
    }

    public Moveable clone() {
        return new Moveable(this);
    }

    protected Moveable createMomento() {
       return this.clone();
    }

    protected void revertMomento(Moveable m) {
        super.setMomento(m.getCollide());
        for(int i =0; i < this.speed.length; i++) {this.speed[i] = m.speed[i];}
    }

    public void setSpeedUp(int i) {
        this.speed[0] = i;
    }

    public void setSpeedRight(int i) {
        this.speed[1] = i;
    }

    public void setSpeedDown(int i) {
        this.speed[2] = i;
    }

    public void setSpeedLeft(int i) {
        this.speed[3] = i;
    }

    public boolean equals(Moveable m) {
        if(this.getCollide().equals(m.getCollide()) && equalsSpeed(m)) {return true;}
        return false;
    }

    private boolean equalsSpeed(Moveable m) {
        for(int i = 0; i< speed.length; i++) {
            if(this.speed[i] != m.speed[i]) {return false;}
        }
        return true;
    }

    public void saveMomento() {
        this.momento = this.clone();
    }

    public void revertMomento() {
        this.revertMomento(momento);
    }


}
