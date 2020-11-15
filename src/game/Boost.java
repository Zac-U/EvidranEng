package game;

import engine.aspect.Level;
import engine.aspect.Stage;
import engine.component.Direction;
import engine.entity.entity;
import engine.event.collisionEvent;

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

        collisionEvent E = this.move(g);
        E.getEntity().accept(this,E.getDirection());

        if (dead) { g.kill(this); }
    }

    public int getSpeedUp() { return this.speedUp; }

    @Override
    public void accept(DeathBorder D, Direction direction) { dead = true; }

    @Override
    public void accept(player p, Direction direction) {
        dead = true;
        p.accept(this, Direction.opposite(direction));
    }
}
