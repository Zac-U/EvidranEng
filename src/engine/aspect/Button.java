package engine.aspect;


import engine.Location;
import engine.Volume;
import engine.draw.*;
import javafx.scene.canvas.Canvas;

//button class describes buttons
public class Button extends Volume implements drawable{

    facade f;

    public Button(int x, int y, int volx, int voly) {
        super(x,y,volx, voly);
    }

    public Button(int x, int y, int volx, int voly, facade d) {
        super(x,y,volx, voly);
        this.f = d;
    }

    @Override
    public void draw(Canvas board) {
        f.draw(board);
    }
}
