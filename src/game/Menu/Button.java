package game.Menu;

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
    image picture = new image("file:src/game/Resources/Graphics/1080p/gph_player.png");
    boolean clicked = false;

    public Button(int x, int y, int volx, int voly) {
        super(x, y, volx, voly);
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
    public void mouseClick(windowEvent E) {
        clicked = true;
        super.addX(30);
        System.out.print("YES");
    }

    public void draw(GraphicsContext canvas) {
        //picture.draw(canvas, super.getLocation());
        picture.draw(canvas, super.getLocation());
        Text t = new Text();
        t.setText(text);
    }




}
