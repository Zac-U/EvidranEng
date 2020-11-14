package engine.entity;

import engine.core.tick;
import engine.draw.drawable;
import engine.draw.facade;
import engine.event.collisionEvent;
import engine.event.windowEvent;
import engine.physics.Moveable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/***
 * a moveable object with a facade
 *
 * when creating a "Game" the developer creates their own entities by extending this class
 * and overwriting the tick method as well as supplying a facade object
 */
public abstract class entity extends Moveable implements drawable, tick {

    facade f;

    public entity(entity e) {
        super(e.getSuper());
    }

    public entity(int x, int y, int volx, int voly) {
        super(x,y,volx,voly);
    }

    protected Moveable getSuper() {
        return super.clone();
    }

    @Override
    public void draw(GraphicsContext board) {
        //f.giveVolume(super.getVolume());
        //f.draw(board);
    }

    protected void setFacade(facade f) {
        this.f = f;
    }

    public boolean equals(entity e) {
        if(super.equals(e.getSuper())) {return true;}
        return false;
    }

    public void mouseClick(windowEvent E) {}

    public void keyPressed(windowEvent E) {}

    public void keyReleased(windowEvent E) {}

    protected collisionEvent move(game game) {
       return super.move(game.getEntityList());
    }

    public boolean collidesWith(entity e) {
        if(this.equals(e)) {return false;}
        return super.collidesWith(e.getCollide());
    }

    public void visit(entity e) {}

    public void visit(entity e, String direction){}
}
