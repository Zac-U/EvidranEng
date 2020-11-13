package engine.draw;
import java.util.ArrayList; // import the ArrayList class
import javafx.scene.canvas.*;

public class RenderList implements  drawable{
    
    ArrayList<drawable> elements = new ArrayList<drawable>();
    
    public RenderList() {
        
    }
    
    public void add(drawable d)  {
        elements.add(d);
    }
    
    public void render(Canvas c)  {
        for (drawable d: elements) {
            d.draw(c);
        }
    }

    @Override
    public void draw(Canvas board) {
        render(board);
    }
}
