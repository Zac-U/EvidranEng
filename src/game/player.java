package game;

import engine.component.Volume;
import engine.draw.image;
import engine.entity.entity;
import engine.event.collisionEvent;
import engine.event.windowEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class player extends entity {

    int sideSpeed = 5;

    int score = 0;

    //image picture = new image("D:\\Evidran\\src\\game\\Resources\\Graphics\\4k\\gph_player.PNG");

    public void addScore(int i) {
        score += i;
    }

    public player(int x, int y, int volx, int voly) {
        super(x,y,volx,voly);
    }

    //set side speed according to key
    @Override
    public void keyPressed(windowEvent E) {
        if(E.getKey().equals("A")) {
            System.out.print("Setting Speed up\n");
            super.setSpeedUp(sideSpeed);
            System.out.print(this.getSpeedUp()+ " speed \n");
        }
        else if(E.getKey().equals("D")) {
            System.out.print("Setting Speed down\n");
            super.setSpeedDown(sideSpeed);
            System.out.print(this.getSpeedDown()+ " speed \n");
        }
        System.out.print(this.getVolX() +" "+ this.getVolY()+" volumes\n");

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
        System.out.print(this.getY() + " Y\n");
        collisionEvent collide = super.move(g);
        System.out.print(this.getY() + " Y\n");
        if(collide != null) {
            collide.getEntity().visit(this, collide.getDirection());
        }

    }

    public void visit(wall w, String direction) {
        if(direction.equals("LEFT")) {
            //move player back by wall speed
        }
    }

    public void draw(GraphicsContext canvas) {
        //picture.draw(canvas, super.getLocation());
        canvas.setFill(Color.RED);
        canvas.fillRect(this.getX(), this.getY(),this.getVolX(),this.getVolY());

    }
}
