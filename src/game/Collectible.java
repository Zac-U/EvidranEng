package game;

import engine.aspect.Level;
import engine.aspect.Stage;
import engine.component.Location;
import engine.draw.image;
import engine.entity.entity;
import engine.event.collisionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Collectible extends entity {

    boolean collected;
    image myImage;

    public Collectible(int x, int y, int volx, int voly, String path, Level.speed s) {
        super(x,y,volx,voly,s);
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
        this.setSpeedLeft(g.getLevel().getSpeed().getSpeed());
    }

    @Override
    public void draw(GraphicsContext board) {
        myImage.draw(board, super.getLocation());
    }
}
