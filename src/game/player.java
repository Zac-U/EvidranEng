package game;

import engine.aspect.Level;
import engine.component.Direction;
import engine.component.Volume;
import engine.draw.image;
import engine.entity.entity;
import engine.event.collisionEvent;
import engine.event.windowEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class player extends entity {

    int sideSpeed = 15;
    int score = 0;
    image picture = new image("file:src/game/Resources/Graphics/1080p/gph_player.png");

    public player(int x, int y, Level.speed s) {
        super(x,y,72,83,s);
        this.setName("Player");
    }

    //set side speed according to key
    @Override
    public void keyPressed(windowEvent E) {
        if(E.getKey().equals("A")) {
            super.setSpeedUp(sideSpeed);
        }
        else if(E.getKey().equals("D")) {
            super.setSpeedDown(sideSpeed);
        }
    }

    @Override
    public void keyReleased(windowEvent E) {
        if(E.getKey().equals("A")) {
            this.setSpeedUp(0);

        }
        else if(E.getKey().equals("D")) {
            this.setSpeedDown(0);
        }
    }

    @Override
    public void tick(game g) {
        boundY();
        this.move(g);
        if (dead) { kill(g); }
    }

    //TODO: end the game
//    @Override
    protected void kill(game g) {}

    private void boundY() {
        int boundingDistance = 6;
        if (this.getY() <= boundingDistance) {
            this.setY(boundingDistance);
            this.setSpeedUp(0);
        }
        else if (this.getY() >= 1080 - boundingDistance) {
            this.setY(1080 - boundingDistance);
            this.setSpeedDown(0);
        }
    }

    public void draw(GraphicsContext canvas) {
        picture.draw(canvas, super.getLocation());
    }

    public void visit(wall w){
        System.out.print("player accepts wall\n");
    }

    @Override
    public void accept(Boost b, Direction direction) {
        int newSpeed = this.getSpeedRight() + b.getSpeedUp();
        this.setSpeedRight(newSpeed);
    }

    @Override
    public void accept(Coin c, Direction direction) { score += c.getValue(); }

    @Override
    public void accept(DeathBorder D, Direction direction) { dead = true; }

    @Override
    public void accept(wall w, Direction direction) {
        System.out.println("here");
        if(direction.equals(Direction.LEFT)) {
            pushBack();
        } else if (direction.equals(Direction.UP)) {
            pushUp();
        } else if (direction.equals(Direction.DOWN)) {
            pushDown();
        }
    }

    public void pushBack(){
        this.addX(-this.coreSpeed.getSpeed());
    }

    public void pushUp(){
        this.addY(-this.sideSpeed);
    }

    public void pushDown(){
        this.addY(this.sideSpeed);
    }
}
