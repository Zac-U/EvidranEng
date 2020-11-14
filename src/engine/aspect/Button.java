package engine.aspect;


import engine.component.Volume;
import engine.draw.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

//button class describes buttons
public class Button extends Volume implements drawable{

    facade f;
    boolean clicked; //causes update upon tick

    public Button(int x, int y, int volx, int voly) {
        super(x,y,volx, voly);
    }

    public Button(int x, int y, int volx, int voly, facade d) {
        super(x,y,volx, voly);
        this.f = d;
    }

    private void setLocal(){
        f.giveVolume(super.clone());
    }

    @Override
    public void draw(GraphicsContext board) {
        f.giveVolume(super.getVolume());
        f.draw(board);
    }
}
