package game;

import engine.aspect.Level;
import engine.aspect.Stage;
import engine.draw.image;
import engine.entity.entity;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public abstract class Collectible extends entity {

    boolean collected;
    image myImage;

    public Collectible(entity e, String path) {
        super(e);
        collected = false;
        myImage = new image(path);
    }

    @Override
    public void tick(game g) {
        if (collected) {
            Stage stage = g.getCurrentStage();
            Level level = stage.getLevel();
            level.removeEntity(this);
        }
    }

    @Override
    public void draw(Canvas board) {
        super.draw(board);
    }

    // gives a perk and then destroys itself
    abstract public void collect(entity player);
}
