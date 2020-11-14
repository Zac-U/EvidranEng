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
            super.setSpeedUp(sideSpeed);
        }
        else if(E.getKey().equals("D")) {
            super.setSpeedDown(sideSpeed);
        }
    }

    @Override
    public void keyReleased(windowEvent E) {
        if(E.getKey().equals("A")) {
            super.setSpeedUp(0);
        }
        else if(E.getKey().equals("D")) {
            super.setSpeedDown(0);
        }
    }

    @Override
    public void tick(game g) {

        collisionEvent collide = super.move(g);
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
        System.out.print("Drawing\n");
        canvas.setFill(Color.RED);
        canvas.fillRect(this.getX(), this.getY(),this.getVolX(),this.getVolY());
        System.out.print(this.getX()+ " " + this.getY() +"\n");
    }
}
