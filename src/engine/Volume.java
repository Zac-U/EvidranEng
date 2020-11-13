package engine;

public class Volume extends Location {

    private int volX, volY;

    public Volume(int x, int y, int vX, int vY) {
        super(x,y);

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
        //if point is greater than TL and less the BR then it's in point
        if(  (this.getTL().greaterX(point.getX()) && this.getTL().greaterY(point.getY())) &&
                (this.getBR().lesserX(point.getX()) && this.getTL().lesserX(point.getY()))      )  {
            return true;
        }
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

}
