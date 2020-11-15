package game.Menu;

import engine.entity.entity;
import engine.event.windowEvent;
import engine.component.Location;
import engine.draw.image;
import engine.entity.entity;
import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;
import java.util.Random;

public class Button extends entity{

    String text;
    String strNextStage;
    image picture = new image("file:src/game/Resources/Graphics/1080p/gph_player.png");

    public Button(int x, int y, int volx, int voly) {
        super(x,y,volx,voly);
    }

    public void setText(String text){
        this.text = text;
    }
    public void setSrtNextStage(String strNextStage){this.strNextStage = strNextStage;};

    @Override
    public void tick(game g) {
        //draw button
    }

    @Override
    public void mouseClick(windowEvent E) {

        //change scene somehow. Do we use visitor for this?
    }

    public void draw(GraphicsContext canvas) {
        //picture.draw(canvas, super.getLocation());
        picture.draw(canvas, super.getLocation());
    }
}
