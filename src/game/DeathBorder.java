package game;

import engine.component.Volume;
import engine.draw.image;
import engine.entity.entity;
import engine.event.collisionEvent;
import engine.event.windowEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DeathBorder extends entity {

    //image picture = new image("D:\\Evidran\\src\\game\\Resources\\Graphics\\4k\\gph_errorwall.PNG");

    DeathBorder(int x, int y, int volx, int voly) {
        super(x,y,volx,voly);
    }

    @Override
    public void tick(game g) {

    }
}

