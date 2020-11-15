package engine.entity;

import engine.core.tick;
import engine.draw.drawable;
import engine.event.collisionEvent;
import engine.event.windowEvent;
import engine.physics.Moveable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import game.*;

/***
 * a moveable object with a facade
 *
 * when creating a "Game" the developer creates their own entities by extending this class
 * and overwriting the tick method as well as supplying a facade object
 */
public abstract class entity extends Moveable implements drawable, tick {



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
    public void draw(GraphicsContext board) {}


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

    public void accept(Boost b, String direction){}

    public void accept(Coin c, String direction){}

    public void accept(DeathBorder D, String direction){}

    public void accept(wall w, String direction){}

    public void accept(player p, String direction){}

}
