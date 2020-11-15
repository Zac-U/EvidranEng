package game;

import engine.aspect.Level;
import engine.aspect.Stage;
import engine.draw.image;
import engine.entity.entity;
import engine.event.collisionEvent;
import javafx.scene.canvas.GraphicsContext;

public class wall extends entity {

    image picture = new image("file:src/game/Resources/Graphics/1080p/gph_wall.png");

    public wall(int x, int y) {
        super(x, y, 96, 446);
        this.setName("Wall");
    }

    @Override
    public void tick(game g) {
        this.setSpeedLeft(5);
        collisionEvent collide = this.move(g);
        if (collide != null) {
            System.out.print("collision\n");
            collide.getEntity().visit(this, collide.getDirection());
        }
        if (this.getX() < (-this.getVolX())) {
            Stage stage = g.getCurrentStage();
            Level level = stage.getLevel();
            level.removeEntity(this);
            level.removeMid(this);
        }
    }

    public void draw(GraphicsContext canvas) {
        picture.draw(canvas, this.getLocation());
    }

}
