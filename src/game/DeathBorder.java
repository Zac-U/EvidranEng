package game;

import engine.aspect.Level;
import engine.component.Location;
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

    image picture = new image("file:src/game/Resources/Graphics/1080p/gph_errorwall.png");
    int countdown;
    int chanceOfWall = 5;
    final int interval = 60;
    final int miny = 350;
    final int maxx = 1920;

    DeathBorder(int x, int y, int volx, int voly) {
        super(x,y,volx,voly);
        countdown = interval;
        this.setName("DeathBorder");
    }

    @Override
    public void tick(game g) {
        // considers generating a new wall
        if (countdown == 0) {
            Random rand = new Random();
            Level level = g.getLevel();
            int ypos;
            // randomly decides whether or not to generate a wall
            if (rand.nextInt(chanceOfWall) < 3) {

                ypos = rand.nextInt(miny);
                wall newWall = new wall(maxx, ypos);
                level.addEntity(newWall);
                level.addMid(newWall);
            }
            // randomly decides wither or not to place 2 walls
            else if (rand.nextInt(chanceOfWall) == 4){

                ypos = rand.nextInt(miny);
                wall wall1 = new wall(maxx, ypos);
                level.addEntity(wall1);
                level.addMid(wall1);
                ypos = rand.nextInt(miny);
                wall wall2 = new wall(maxx, ypos);
                level.addEntity(wall2);
            }
            countdown = interval;
        } else {
            countdown--;
        }
    }

    public void draw(GraphicsContext canvas) {
        //picture.draw(canvas, super.getLocation());
        picture.draw(canvas, super.getLocation());
    }

    public void accept(wall w) {
        System.out.print("Death wall meets wall\n");
        //w.removeWall();
    }

    //TODO: accept wall, coin, boost and player. destroy all of them


    @Override
    public void accept(Boost b, String direction) {
        //destroy them
    }

    @Override
    public void accept(Coin c, String direction) {
        //destroy them
    }

    @Override
    public void accept(wall w, String direction) {
        //destroy them
    }

    @Override
    public void accept(player p, String direction) {
        //destroy them
    }
}


