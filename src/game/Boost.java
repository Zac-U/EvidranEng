package game;

import engine.entity.entity;

public class Boost extends Collectible {

    int speedUp;

    public Boost(entity e, int x, int y, int volx, int voly) {
        super(x, y, volx, voly, "game/Resources.Graphics.4k/gph_coin.png");
        speedUp = 10;
    }

    // increase player's speed and then gets destroyed
    public void collect(player player) {
        int newSpeed = player.getSpeedRight() + speedUp;
        player.setSpeedRight(newSpeed);
        collected = true;
    }
}