package game;

import engine.aspect.Level;
import engine.component.Location;
import engine.draw.image;
import engine.entity.entity;
import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;
import java.util.Random;

public class Background extends entity{

    ArrayList<image> tiles;
    int[] currentTiles;
    Random rand;

    Background(Level.speed speed) {
        super(0, 0, 1920, 1080, speed);
        setTiles();
        rand = new Random();
        currentTiles =  new int[] {0, rand.nextInt(6)};
        super.setCollider(false);
        this.setName("Background");

    }

    private void setTiles() {
        tiles = new ArrayList();
        tiles.add(new image("file:src/game/Resources/Graphics/1080p/gph_circuit_1.png"));
        tiles.add(new image("file:src/game/Resources/Graphics/1080p/gph_circuit_2.png"));
        tiles.add(new image("file:src/game/Resources/Graphics/1080p/gph_circuit_3.png"));
        tiles.add(new image("file:src/game/Resources/Graphics/1080p/gph_circuit_4.png"));
        tiles.add(new image("file:src/game/Resources/Graphics/1080p/gph_circuit_5.png"));
        tiles.add(new image("file:src/game/Resources/Graphics/1080p/gph_circuit_6.png"));
    }

    @Override
    public void tick(game g) {
        this.setSpeedLeft(g.getLevel().getSpeed().getSpeed()/2);
        this.move(g);

        if (this.getX() + this.getVolX() < 0) {
            this.setX(this.getX() + 1920);
            currentTiles[0] = currentTiles[1];
            currentTiles[1] = rand.nextInt(6);
        }
    }

    public void draw(GraphicsContext canvas) {
        tiles.get(currentTiles[0]).draw(canvas, this.getLocation());
        tiles.get(currentTiles[1]).draw(canvas, this.getLocation().add(new Location(1920, 0)));
    }

}
