package engine.component;

/***
 * A POJO for holding a 2D point in space
 * Has associated functions for comparing points in space
 */
public class Location {

    private String name;
    private int x,y;


    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Location(Location l) {
        this.x = l.x;
        this.y = l.y;
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

    protected Location clone() {
        return new Location(this.x, this.y);
    }

    protected void addX(int V) {
        this.x = this.x + V;
    }

    protected void addY(int V) {
        this.y = this.y + V;
    }

    public Location add(Location l) {return new Location(this.x + l.x, this.y + l.y);}

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

    public boolean equals(Location L) {
        if(L.x == this.x && L.y == this.y) {return true;}
        return false;
    }

    protected void setMomento(Location L) {
        this.x = L.x;
        this.y = L.y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
