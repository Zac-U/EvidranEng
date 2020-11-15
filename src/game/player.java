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

    int sideSpeed = 15;

    int score = 0;

    image picture = new image("file:src/game/Resources/Graphics/1080p/gph_player.png");

    public void addScore(int i) {
        score += i;
    }

    public player(int x, int y) {
        super(x,y,72,83);
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
       collisionEvent collide = this.move(g);
        if(collide != null) {
            System.out.print("collision\n");
            collide.getEntity().visit(this, collide.getDirection());

        }

    }

    public void draw(GraphicsContext canvas) {
        picture.draw(canvas, super.getLocation());
    }


    public void visit(wall w){
        System.out.print("player accepts wall\n");
    }




}
