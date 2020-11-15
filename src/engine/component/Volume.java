package engine.component;

/***
 * A POJO for holding a rectangular reigon of space starting from a location that is in the top left of the rectangle
 *
 */
public class Volume extends Location {

    private int volX, volY;

    public Volume(int x, int y, int vX, int vY) {
        super(x,y);
        volX = vX;
        volY = vY;
    }

    public Volume(Volume v) {
        super(v.getLocation());
        this.volX = v.volX;
        this.volY = v.volY;

    }

    public int getVolY() {
        return volY;
    }

    public void setVolY(int volY) {
        this.volY = volY;
    }

    public int getVolX() {
        return volX;
    }

    public void setVolX(int volX) {
        this.volX = volX;
    }


    private Location getTL() {
        return super.clone();
    }


    private Location getTR() {
        Location temp = super.clone();
        temp.addX(this.getVolX());
        return temp;
    }


    private Location getBL() {
        Location temp = super.clone();
        temp.addY(this.getVolY());
        return temp;
    }


    private Location getBR() {
        Location temp = super.clone();
        temp.addX(this.getVolX());
        temp.addY(this.getVolY());
        return temp;
    }

    public boolean locateInVol(Location point)  {
        int X1 = this.getTL().getX();
        int X2 = this.getBR().getX();
        int Y1 = this.getTL().getY();
        int Y2 = this.getBR().getY();
        int XP = point.getX();
        int YP = point.getY();
        if( (XP >= X1 && XP <= X2) && (YP >= Y1 && YP<=Y2)) {return true;}
        return false;
    }

    public boolean locateInVolEx(Location point)  {
        int X1 = this.getTL().getX();
        int X2 = this.getBR().getX();
        int Y1 = this.getTL().getY();
        int Y2 = this.getBR().getY();
        int XP = point.getX();
        int YP = point.getY();
        if( (XP > X1 && XP < X2) && (YP > Y1 && YP<Y2)) {return true;}
        return false;
    }

    public boolean IntersectEx(Volume outside) {
        if(this.locateInVolEx(outside.getBL()) ||
                this.locateInVolEx(outside.getTL()) ||
                this.locateInVolEx(outside.getBR()) ||
                this.locateInVolEx(outside.getTR())){ return true;}
        return false;
    }

    public boolean Intersect(Volume outside) {
        if(this.locateInVol(outside.getBL()) ||
           this.locateInVol(outside.getTL()) ||
           this.locateInVol(outside.getBR()) ||
           this.locateInVol(outside.getTR())){ return true;}
        return false;
    }

    public Location getLocation(){
        return super.clone();
    }

    public Volume clone() {
        return new Volume(this);
    }

    public boolean equals(Volume V) {
        if(super.equals(V.getLocation()) && this.volX == V.volX && this.volY == V.volY) {return true;}
        return false;
    }

    protected void setMomento(Volume v) {
        super.setMomento(v.getLocation());
        this.setVolX(v.getVolX());
        this.setVolY(v.getVolY());
    }

    protected Volume getVolume() {return this.clone();}

}
