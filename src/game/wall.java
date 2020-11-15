package game;

import engine.aspect.Level;
import engine.aspect.Stage;
import engine.draw.image;
import engine.entity.entity;
import engine.event.Visitor;
import engine.event.collisionEvent;
import javafx.scene.canvas.GraphicsContext;

public class wall extends entity {

    boolean remove = false;

    image picture = new image("file:src/game/Resources/Graphics/1080p/gph_wall.png");

    public wall(int x, int y) {
        super(x, y, 96, 446);
        this.setName("Wall");
        this.setSpeedLeft(5);
    }

    @Override
    public void tick(game g) {
        if(remove){this.removeWall(g);}
        collisionEvent collide = this.move(g);
        if (collide != null) {
            collide.getEntity().visit(this, collide.getDirection());
        }
        if (this.getX() < (-this.getVolX())) {
            removeWall(g);
        }
    }

    public void removeWall() {remove = true;}

    public void removeWall(game g) {
        Stage stage = g.getCurrentStage();
        Level level = stage.getLevel();
        level.removeEntity(this);
        level.removeMid(this);
    }

    public void draw(GraphicsContext canvas) {
        picture.draw(canvas, this.getLocation());
    }

    public void visit(DeathBorder d) {
        this.remove = true;
    }

    public void accept(Visitor visitor) {
        visitor.accept(this);
    }

}
