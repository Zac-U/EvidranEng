package game;

import engine.aspect.Level;
import engine.aspect.Stage;
import engine.draw.image;
import engine.entity.entity;
import engine.event.collisionEvent;
import javafx.scene.canvas.GraphicsContext;

public class wall extends entity {

    boolean remove = false;

    image picture = new image("file:src/game/Resources/Graphics/1080p/gph_wall.png");

    public wall(int x, int y, Level.speed s) {
        super(x, y, 96, 446, s);
        this.setName("Wall");

    }

    @Override
    public void tick(game g) {
        if(remove){this.removeWall(g);}
        this.setSpeedLeft(g.getLevel().getSpeed().getSpeed());
        collisionEvent collide = this.move(g);
        if (collide != null) {
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

    public void accept(player p) {
        System.out.print("wall accepts player\n");
    }

    public void accept(DeathBorder d){
        System.out.print("Death wall meets wall\n");
    }

    //TODO: accept player, deathwall


    @Override
    public void accept(DeathBorder D, String direction) {
        //destroy myself
    }

    @Override
    public void accept(player p, String direction) {
        if(direction.equals("RIGHT")) {
            p.pushBack();
        }
        else if(direction.equals("UP")) {
            p.pushDown();
        }
        else if(direction.equals("DOWN")) {
            p.pushUp();
        }
    }
}
