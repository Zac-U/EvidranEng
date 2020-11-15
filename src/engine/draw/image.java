package engine.draw;


import engine.component.Location;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class image {

    private final String directory;
    private final  Image picture;

    public image(String directory) {
        this.directory = directory;
        picture = new Image(this.directory, 50, 50, false, false);

    }

    public void draw(GraphicsContext canvas, Location local) {
        canvas.drawImage(picture,local.getX(),local.getY());
    }
}
