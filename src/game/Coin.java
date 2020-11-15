package game;

import engine.aspect.Level;
import engine.aspect.Stage;
import engine.component.Direction;
import engine.draw.image;
import engine.entity.entity;
import engine.event.collisionEvent;

import java.util.Random;

public class Coin extends Collectible {

    int value;

    public Coin(entity e, int x, int y, int volx, int voly, Level.speed s) {
        super(x, y, volx, voly, "file:src/game/Resources.Graphics.1080p/gph_coin.png", s);
        Random rand = new Random();
        value = (1 + rand.nextInt(3)) * 10;
        this.setName("Coin");

    }

    @Override
    public void tick(game g) {

        collisionEvent E = this.move(g);
        E.getEntity().accept(this,E.getDirection());

        if (collected) {
            Stage stage = g.getCurrentStage();
            Level level = stage.getLevel();
            level.removeEntity(this);
        }
    }

    // adds value to the score and then gets destroyed
//    public void collect(player player) {
//        player.addScore(value);
//        collected = true;
//    }

    //TODO: accept player and death wall


    @Override
    public void accept(DeathBorder D, Direction direction) {
        //destroy myself
        collected = true;
    }

    @Override
    public void accept(player p, Direction direction) {
        //get collected
        p.accept(this, direction);
        collected = true;
    }
}
