package game;

import engine.aspect.Level;
import engine.aspect.Stage;
import engine.component.Direction;
import engine.draw.image;
import engine.entity.entity;
import engine.event.collisionEvent;
import javafx.scene.canvas.GraphicsContext;

public class wall extends entity {

    private boolean dead;
    image picture = new image("file:src/game/Resources/Graphics/1080p/gph_wall.png");

    public wall(int x, int y, Level.speed s) {
        super(x, y, 96, 446, s);
        this.setName("Wall");
        this.dead = false;
    }

    @Override
    public void tick(game g) {
        if (dead) { kill(g); }
        this.setSpeedLeft(g.getLevel().getSpeed().getSpeed());
        collisionEvent collide = this.move(g);
        //TODO: review if the following is necessary
        if (collide != null) {
        }
        if (this.getX() < (-this.getVolX())) {
            kill(g);
        }
    }

    public void kill(game g) {
        Stage stage = g.getCurrentStage();
        Level level = stage.getLevel();
        level.removeEntity(this);
        level.removeMid(this);
    }

    public void draw(GraphicsContext canvas) { picture.draw(canvas, this.getLocation()); }

    @Override
    public void accept(DeathBorder D, Direction direction) { dead = true; }

    @Override
    public void accept(player p, Direction direction) { p.accept(this, Direction.opposite(direction)); }
}
