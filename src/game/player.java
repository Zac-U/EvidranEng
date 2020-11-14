package game;

import engine.component.Volume;
import engine.entity.entity;
import engine.event.collisionEvent;
import engine.event.windowEvent;

public class player extends entity {

    int sideSpeed = 5;

    int score = 0;

    public void addScore(int i) {
        score += i;
    }

    public player(int x, int y, int volx, int voly) {
        super(x,y,volx,voly);
    }

    //set side speed according to key
    @Override
    public void keyPressed(windowEvent E) {
        if(E.getKey().equals("A")) {
            super.setSpeedUp(sideSpeed);
        }
        else if(E.getKey().equals("D")) {
            super.setSpeedDown(sideSpeed);
        }
    }

    @Override
    public void keyReleased(windowEvent E) {
        if(E.getKey().equals("A")) {
            super.setSpeedUp(0);
        }
        else if(E.getKey().equals("D")) {
            super.setSpeedDown(0);
        }
    }

    @Override
    public void tick(game g) {

        collisionEvent collide = super.move(g);
        if(collide != null) {
            collide.getEntity().visit(this);
        }

    }

    public void visit(wall w) {

    }
}
