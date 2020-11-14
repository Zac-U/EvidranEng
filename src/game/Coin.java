package game;

import engine.entity.entity;
import java.util.Random;

public class Coin extends Collectible {

    int value;

    public Coin(entity e, int x, int y, int volx, int voly) {
        super(x, y, volx, voly, "game/Resources.Graphics.4k/gph_coin.png");
        Random rand = new Random();
        value = (1 + rand.nextInt(3)) * 10;
    }

    // adds value to the score and then gets destroyed
    public void collect(player player) {
        player.addScore(value);
        collected = true;
    }

}
