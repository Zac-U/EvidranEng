package game;

import engine.aspect.Level;
import engine.component.Direction;
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
    Random rand = new Random();

    DeathBorder(int x, int y, int volx, int voly, Level.speed s) {
        super(x,y,volx,voly, s);
        countdown = interval;
        this.setName("DeathBorder");
    }

    @Override
    public void tick(game g) {
        Level level = g.getLevel();
        generateWalls(level);
        //generateCoins(level);
        countdown--;
        if (countdown < 0) {
            countdown = interval;
        }
    }

    private void generateCoins(Level level) {
        // considers generating a new wall
        if (countdown == interval / 2) {
            // randomly decides whether or not to generate a wall
            if (rand.nextInt(chanceOfWall) < 3) {
                addCoin(level, rand.nextInt(miny));
            }
            // randomly decides wither or not to place 2 walls
            else if (rand.nextInt(chanceOfWall) == 4) {
                addCoin(level, rand.nextInt(miny));
                addCoin(level, rand.nextInt(miny));
            }
        }
    }

    private void generateWalls(Level level) {
        // considers generating a new wall
        if (countdown == 0) {
            // randomly decides whether or not to generate a wall
            if (rand.nextInt(chanceOfWall) < 3) {
                addWall(level, rand.nextInt(miny));
            }
            // randomly decides whether or not to place 2 walls
            else if (rand.nextInt(chanceOfWall) == 4) {
                addWall(level, rand.nextInt(miny));
                addWall(level, rand.nextInt(miny));
            }
        }
    }

    private void addCoin(Level level, int ypos) {
        Coin newCoin = new Coin(maxx, ypos, 29,30, level.getSpeed());
        level.addEntity(newCoin);
        level.addMid(newCoin);
    }

    private void addWall(Level level, int ypos) {
        wall newWall = new wall(maxx, ypos, level.getSpeed());
        level.addEntity(newWall);
        level.addMid(newWall);
    }

    public void draw(GraphicsContext canvas) { picture.draw(canvas, super.getLocation()); }

    @Override
    public void accept(Boost b, Direction direction) { b.accept(this, Direction.opposite(direction)); }

    @Override
    public void accept(Coin c, Direction direction) { c.accept(this, Direction.opposite(direction)); }

    @Override
    public void accept(wall w, Direction direction) { w.accept(this, Direction.opposite(direction)); }

    @Override
    public void accept(player p, Direction direction) { p.accept(this, Direction.opposite(direction)); }
}
