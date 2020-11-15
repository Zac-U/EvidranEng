package game.Menu;

import engine.entity.entity;
import engine.event.Visitor;
import engine.event.windowEvent;
import engine.component.Location;
import engine.draw.image;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Text;
import engine.aspect.Stage;

public class SimpleGraphic extends entity{

    image picture;

    public SimpleGraphic(int x, int y, int volx, int voly, String path) {
        super(x, y, volx, voly);
        picture = new image(path);
    }

    @Override
    public void tick(game g) {

    }

    @Override
    public void accept(Visitor visitor) {

    }

    public void draw(GraphicsContext canvas) {
        picture.draw(canvas, super.getLocation());
    }
}
