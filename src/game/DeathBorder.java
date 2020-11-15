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
    int countdown;
    int chanceOfWall = 4;
    final int interval = 60;
    final int miny = 350;
    final int maxx = 1920;

    DeathBorder(int x, int y, int volx, int voly) {
        super(x,y,volx,voly);
        countdown = interval;
    }

    @Override
    public void tick(game g) {
        // considers generating a new wall
        if (countdown == 0) {
            Random rand = new Random();
            // randomly decides whether or not to generate a wall
            if (rand.nextInt(chanceOfWall) == 0) {
                Level level = g.getLevel();
                int ypos = rand.nextInt(miny);
                wall newWall = new wall(maxx, ypos);
                level.addEntity(newWall);
            }
            countdown = interval;
        } else {
            countdown--;
        }
    }

    public void draw(GraphicsContext canvas) {
        picture.draw(canvas, super.getLocation());
    }
}

