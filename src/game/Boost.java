package game;

import engine.entity.entity;
import engine.event.Visitor;

public class Boost extends Collectible {

    int speedUp;

    public Boost(entity e, int x, int y, int volx, int voly) {
        super(x, y, volx, voly, "file:src/game/Resources.Graphics.4k/gph_coin.png");
        speedUp = 10;
        this.setName("Boost");
    }

    // increase player's speed and then gets destroyed
    public void collect(player player) {
        int newSpeed = player.getSpeedRight() + speedUp;
        player.setSpeedRight(newSpeed);
        collected = true;
    }

    public void accept(Visitor visitor) {
        visitor.accept(this);
    }
}
