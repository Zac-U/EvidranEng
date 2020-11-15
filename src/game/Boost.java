package game;

import engine.aspect.Level;
import engine.aspect.Stage;
import engine.component.Direction;
import engine.entity.entity;
import engine.event.collisionEvent;

public class Boost extends Collectible {

    int speedUp;

    public Boost(entity e, int x, int y, int volx, int voly, Level.speed s) {
        super(x, y, volx, voly, "file:src/game/Resources.Graphics.4k/gph_coin.png", s);
        speedUp = 10;
        this.setName("Boost");

    }

    @Override
    public void tick(game g) {
        this.setSpeedLeft(g.getLevel().getSpeed().getSpeed());

        collisionEvent E = this.move(g);
        E.getEntity().accept(this,E.getDirection());

        if (collected) {
            Stage stage = g.getCurrentStage();
            Level level = stage.getLevel();
            level.removeEntity(this);
        }
    }

    // increase player's speed and then gets destroyed
//    public void collect(player player) {
//        int newSpeed = player.getSpeedRight() + speedUp;
//        player.setSpeedRight(newSpeed);
//        collected = true;
//    }

    //TODO: accept player and deathwall


    @Override
    public void accept(DeathBorder D, Direction direction) {
        //kill myself
        collected = true;
    }

    @Override
    public void accept(player p, Direction direction) {
        //boost player
        // int newSpeed = p.getSpeedRight() + speedUp;
        p.accept(this, direction);
    }
}
