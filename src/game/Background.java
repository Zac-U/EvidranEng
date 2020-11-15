package game;

import engine.component.Volume;
import engine.draw.image;
import engine.entity.entity;
import engine.event.collisionEvent;
import engine.event.windowEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Random;

public class Background extends entity{

    ArrayList<image> tiles;
    int[] currentTiles;
    Random rand;

    Background(int x, int y, int volx, int voly) {
        super(x, y, volx, voly);
        setTiles();
        rand = new Random();
        currentTiles =  new int[] {0, rand.nextInt(6)};
    }

    private void setTiles() {
        tiles = new ArrayList();
        tiles.add(new image("file:src/game/Resources/Graphics/1080p/gph_circuit1.png"));
        tiles.add(new image("file:src/game/Resources/Graphics/1080p/gph_circuit2.png"));
        tiles.add(new image("file:src/game/Resources/Graphics/1080p/gph_circuit3.png"));
        tiles.add(new image("file:src/game/Resources/Graphics/1080p/gph_circuit4.png"));
        tiles.add(new image("file:src/game/Resources/Graphics/1080p/gph_circuit5.png"));
        tiles.add(new image("file:src/game/Resources/Graphics/1080p/gph_circuit6.png"));
    }

    @Override
    public void tick(game g) {
        this.setSpeedLeft(5);
        this.move(g);
        if (this.getX() + this.getVolX() < 0) {
            this.setX(this.getX() + 1920);
            currentTiles[0] = currentTiles[1];
            currentTiles[1] = rand.nextInt(6);
        }
    }

    public void draw(GraphicsContext canvas) {
        tiles.get(currentTiles[0]).draw(canvas, super.getLocation());
        tiles.get(currentTiles[1]).draw(canvas, super.getLocation());
        //canvas.setFill(Color.RED);
        //canvas.fillRect(this.getX(), this.getY(),this.getVolX(),this.getVolY());

    }
}
