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

public class Background extends entity{

    ArrayList<image> tiles;

    Background(int x, int y, int volx, int voly) {
        super(x, y, volx, voly);
    }

    @Override
    public void tick(game g) {

    }
}
