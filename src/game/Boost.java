package game;

import engine.aspect.Level;
import engine.aspect.Stage;
import engine.component.Direction;
import engine.entity.entity;
import engine.event.collisionEvent;

import java.util.ArrayList;

public class Boost extends Collectible {

    private int speedUp;

    public Boost(entity e, int x, int y, int volx, int voly, Level.speed s) {
        super(x, y, volx, voly, "file:src/game/Resources.Graphics.4k/gph_coin.png", s);
        speedUp = 10;
        this.setName("Boost");

    }

    @Override
    public void tick(game g) {
        this.setSpeedLeft(g.getLevel().getSpeed().getSpeed());

        ArrayList<collisionEvent> collide = this.move(g);
        for (collisionEvent c: collide) {
            c.getEntity().accept(this,c.getDirection());
        }

        if (collected) {
            kill(g);
        }
    }

    private void kill(game g) {
        Stage stage = g.getCurrentStage();
        Level level = stage.getLevel();
        level.removeEntity(this);
        level.removeMid(this);
    }

    public int getSpeedUp() { return this.speedUp; }

    //TODO: accept player and deathwall

    @Override
    public void accept(DeathBorder D, Direction direction) { collected = true; }

    @Override
    public void accept(player p, Direction direction) { p.accept(this, Direction.opposite(direction)); }
}
