package engine;

public class Volumeable extends Locateable{

    private int volX, volY;

    public Volumeable(int x, int y, int vX, int vY) {
        super(x,y);

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


    public Locateable getTL() {
        return super.clone();
    }


    public Locateable getTR() {
        Locateable temp = super.clone();
        temp.addX(this.getVolX());
        return temp;
    }


    public Locateable getBL() {
        Locateable temp = super.clone();
        temp.addY(this.getVolY());
        return temp;
    }


    public Locateable getBR() {
        Locateable temp = super.clone();
        temp.addX(this.getVolX());
        temp.addY(this.getVolY());
        return temp;
    }

    public boolean locateInVol(Locateable point)  {
        //if point is greater than TL and less the BR then it's in point
        if(  (this.getTL().greaterX(point.getX()) && this.getTL().greaterY(point.getY())) &&
                (this.getBR().lesserX(point.getX()) && this.getTL().lesserX(point.getY()))      )  {
            return true;
        }
        return false;
    }

    public boolean Intersect(Volumeable outside) {
        if(this.locateInVol(outside.getBL()) ||
           this.locateInVol(outside.getTL()) ||
           this.locateInVol(outside.getBR()) ||
           this.locateInVol(outside.getTR())){ return true;}
        return false;
    }

}
