package game;

import engine.entity.entity;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public abstract class Collectible extends entity {

    public Collectible(entity e) {
        super(e);
    }

    @Override
    public void tick(game g) {

    }

    @Override
    public void draw(Canvas board) {
        super.draw(board);
    }

    // gives a perk and then destroys itself
    abstract public void collect(entity player);
}
