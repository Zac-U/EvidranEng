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
    int chanceOfItem = 7;
    final int interval = 50;
    final int wally = 350;
    final int coiny = 900;
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
        countdown--;
        if (countdown < 0) {
            generateItem(level);
            countdown = interval;
        }
    }

    private void generateItem(Level level) {
        int value = rand.nextInt(chanceOfItem);
        if (value < 2) {
            addWall(level, rand.nextInt(wally));
        } else if (value < 4) {
            addCoin(level, rand.nextInt(coiny));
        } else if (value < 5) {
            addWall(level, rand.nextInt(wally));
            addWall(level, rand.nextInt(wally));
        } else if (value < 6) {
            addCoin(level, rand.nextInt(coiny));
            addCoin(level, rand.nextInt(coiny));
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
    public void accept(player p, Direction direction) { accept(this, Direction.opposite(direction)); }
}
