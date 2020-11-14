package game;

import engine.draw.image;
import engine.entity.entity;
import javafx.scene.canvas.GraphicsContext;

public class wall extends entity {

    image picture = new image("file:src/game/Resources/Graphics/1080p/gph_wall.png");

    public wall(int x, int y) {
        super(x, y, 96, 446);
    }

    @Override
    public void tick(game g) {
        //set speed to standard speed
        this.setSpeedLeft(5);
        this.move(g);
        //if collide
    }

    public void draw(GraphicsContext canvas) {
        picture.draw(canvas, this.getLocation());
    }

}
