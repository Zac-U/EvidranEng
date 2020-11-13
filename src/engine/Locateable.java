package engine;

/***
 * A POJO for holding a 2D point in space
 * Has associated functions for comparing points in space
 */
public class Locateable {

    private int x,y;


    public Locateable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected void setX(int X) {
        this.x = X;
    }

    protected void setY(int Y) {
        this.y = Y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    protected void setXY(int x, int y)  {
        setX(x);
        setY(y);
    }

    protected Locateable clone() {
        return new Locateable(this.x, this.y);
    }

    protected void addX(int V) {
        this.x = this.x + V;
    }

    protected void addY(int V) {
        this.y = this.y + V;
    }

    //function checks if a given x  value is greater than the held x value
    protected boolean greaterX(int x) {
        if(this.x <= x) {return true;}
        return false;
    }

    //function checks if a given y value is greater than the held y value
    protected boolean greaterY(int y) {
        if(this.y <= y) {return true;}
        return false;
    }

    //function checks if a given x  value is lesser than the held x value
    protected boolean lesserX(int x) {
        if(this.x >= x) {return true;}
        return false;
    }

    //function checks if a given y value is lesser than the held y value
    protected boolean lesserY(int y) {
        if(this.y >= y) {return true;}
        return false;
    }
}
