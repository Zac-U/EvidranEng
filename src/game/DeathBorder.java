package game;

import engine.aspect.Level;
import engine.component.Volume;
import engine.draw.image;
import engine.entity.entity;
import engine.event.collisionEvent;
import engine.event.windowEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class DeathBorder extends entity {

    image picture = new image("file:src/game/Resources/Graphics.1080p/gph_errorwall.png");
    int countdown = 60;

    DeathBorder(int x, int y, int volx, int voly) {
        super(x,y,volx,voly);
    }

    @Override
    public void tick(game g) {
        System.out.println("countdown:" + countdown);
        if (countdown == 0) {
            Random rand = new Random();
            Level level = g.getLevel();
            int ypos = rand.nextInt(1000);
            wall newWall = new wall(1920, ypos);
            level.addEntity(newWall);
            countdown = 60;
        } else {
            countdown--;
        }
    }

    public void draw(GraphicsContext canvas) {
        picture.draw(canvas, super.getLocation());
    }
}

