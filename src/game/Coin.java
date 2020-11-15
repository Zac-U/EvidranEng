package game;

import engine.draw.image;
import engine.entity.entity;
import engine.event.Visitor;

import java.util.Random;

public class Coin extends Collectible {

    int value;

    public Coin(entity e, int x, int y, int volx, int voly) {
        super(x, y, volx, voly, "file:src/game/Resources.Graphics.1080p/gph_coin.png");
        Random rand = new Random();
        value = (1 + rand.nextInt(3)) * 10;
        this.setName("Coin");
    }

    // adds value to the score and then gets destroyed
    public void collect(player player) {
        player.addScore(value);
        collected = true;
    }

    public void accept(Visitor visitor) {
        visitor.accept(this);
    }


}
