package game;

import engine.entity.entity;
import javafx.scene.image.Image;

import java.util.Random;

public class Coin extends Collectible {

    int value;
    Image image;

    public Coin(entity e) {
        super(e);
        String path = "game/Resources.Graphics.4k/gph_wall.png";
        image = new Image(path, 100, 100, true, false);
        Random rand = new Random();
        value = (1 + rand.nextInt(3)) * 10;
    }

    // adds value to the score and then gets destroyed
    public void collect(entity player) {

    }
}
