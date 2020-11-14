package game;

import engine.aspect.Level;
import engine.aspect.Stage;
import engine.component.Location;
import engine.draw.image;
import engine.entity.entity;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Collectible extends entity {

    boolean collected;
    image myImage;

    public Collectible(int x, int y, int volx, int voly, String path) {
        super(x,y,volx,voly);
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
    public void draw(GraphicsContext board) {
        // super.draw(board);
        myImage.draw(board, this);
    }

    // gives a perk and then destroys itself
    abstract public void collect(player player);
}
