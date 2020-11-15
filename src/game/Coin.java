package game;

import engine.aspect.Level;
import engine.aspect.Stage;
import engine.component.Direction;
import engine.draw.image;
import engine.entity.entity;
import engine.event.collisionEvent;

import java.util.ArrayList;
import java.util.Random;

public class Coin extends Collectible {

    private int value;
    private boolean collected;

    public Coin(int x, int y, int volx, int voly, Level.speed s) {
        super(x, y, volx, voly, "file:src/game/Resources/Graphics/1080p/gph_coin.png", s);
        Random rand = new Random();
        value = (1 + rand.nextInt(3)) * 10;
        this.setName("Coin");

    }

    public int getValue(){ return value; }

    @Override
    public void tick(game g) {
        super.tick(g);
        ArrayList<collisionEvent> collide = this.move(g);
        for (collisionEvent c: collide) {
            c.getEntity().accept(this,c.getDirection());
        }


    }

    // adds value to the score and then gets destroyed
//    public void collect(player player) {
//        player.addScore(value);
//        collected = true;
//    }

    //TODO: accept player and death wall


    @Override
    public void accept(DeathBorder D, Direction direction) { dead = true; }

    @Override
    public void accept(player p, Direction direction) {
        dead = true;
        p.accept(this, direction);
//        collected = true;
    }
}
