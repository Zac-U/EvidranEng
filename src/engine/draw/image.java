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
        picture = new Image(this.directory);

    }

    public void draw(Canvas canvas, Location local) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(picture,picture.getWidth(),picture.getHeight());
    }

}
