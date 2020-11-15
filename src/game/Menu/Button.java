package game.Menu;

import engine.aspect.Level;
import engine.entity.entity;
import engine.event.windowEvent;
import engine.component.Location;
import engine.draw.image;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Text;
import engine.aspect.Stage;

public class Button extends entity {

    String text;
    Stage nextStage;
    boolean clicked = false;

    public Button(int x, int y, int volx, int voly, Level.speed s) {
        super(x, y, volx, voly,s);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setNextStage(Stage nextStage) {
        this.nextStage = nextStage;
    }

    @Override
    public void tick(game g) {
        if(clicked){
            g.setCurrentStage(nextStage);
            clicked = false;
        }
    }

    @Override
    public void keyReleased(windowEvent E) {
        /*if(E.getKey().equals("e")) {


        }*/
        clicked = true;
    }

    @Override
    public void mouseClick(windowEvent E) {
        clicked = true;
        super.addX(30);
        System.out.print("YES");
    }


}
