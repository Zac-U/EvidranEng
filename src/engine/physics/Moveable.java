package engine.physics;

//class describes objects that can move
public class Moveable extends Collide {

    private int[] speed = new int[4];

    public Moveable(int x, int y, int volx, int voly) {
        super(x,y,volx,voly);
        for(int i =0; i < speed.length; i++) {speed[i] = 0;}
    }

    public Moveable(Moveable m) {
        super(m.getCollide());
        for(int i =0; i < this.speed.length; i++) {this.speed[i] = m.speed[i];}
        }


    public Collide getCollide() {
        return super.clone();
    }

    private void Move(int i) {
        if(i == 0) {this.addX(-speed[i]);}
        else if(i == 1) { this.addY(speed[i]);}
        else if(i == 2) {this.addX(speed[i]);}
        else if(i == 3) {this.addY(-speed[i]);}
    }

    //go through each speed, create a momento of the object, try move
    //if fail revert to momento
    public void Move(CollideList col){
        for(int i = 0; i<this.speed.length; i++) {
            if(speed[i] != 0) {
                Moveable temp = this.createMomento();
                this.Move(i);
                if(collidesWith(this)) {this.revertMomento(temp);}
            }

        }
    }

    public Moveable clone() {
        return new Moveable(this);
    }

    protected Moveable createMomento() {
       return this.clone();
    }

    protected void revertMomento(Moveable m) {
        super.setMomento(m.getCollide());
        for(int i =0; i < this.speed.length; i++) {this.speed[i] = m.speed[i];}
    }

    public void setSpeedUp(int i) {
        this.speed[0] = i;
    }

    public void setSpeedRight(int i) {
        this.speed[1] = i;
    }

    public void setSpeedDown(int i) {
        this.speed[2] = i;
    }

    public void setSpeedLeft(int i) {
        this.speed[3] = i;
    }

}//TODO implement momento system for handeling collisions
