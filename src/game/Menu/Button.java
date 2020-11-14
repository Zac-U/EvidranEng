package game.Menu;

import engine.entity.entity;
import engine.event.windowEvent;

public class Button extends entity{

    String text;

    Button(int x, int y, int volx, int voly) {
        super(x,y,volx,voly);
    }

    public void setText(String text){
        this.text = text;
    }

    @Override
    public void tick(game g) {
        //draw button
    }

    @Override
    public void mouseClick(windowEvent E) {
        //change scene somehow. Do we use visitor for this?
    }
}
