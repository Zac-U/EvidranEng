package game;

import engine.aspect.Level;
import engine.component.Direction;
import engine.component.Volume;
import engine.draw.image;
import engine.entity.entity;
import engine.event.collisionEvent;
import engine.event.windowEvent;
import engine.physics.Collide;
import engine.sound.sound;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.Random;

public class player extends entity {

    int sideSpeed = 15;
    int score = 0;
    private boolean dead = false;
    private boolean push = false;

    Random rand = new Random();
    ArrayList<String> titles = new ArrayList<>();

    image picture = new image("file:src/game/Resources/Graphics/1080p/gph_player.png");

    public void addScore(int i) {
        score += i;
    }

    public player(int x, int y, Level.speed s) {
        super(x,y,72,83,s);
        this.setName("Player");
        this.dead = false;
        titles.add("src/game/Resources/Sound/Coin_Collect_01.wav");
        titles.add("src/game/Resources/Sound/Coin_Collect_02.wav");
        titles.add("src/game/Resources/Sound/Coin_Collect_03.wav");
        titles.add("src/game/Resources/Sound/Coin_Collect_04.wav");
        titles.add("src/game/Resources/Sound/Coin_Collect_05.wav");
        titles.add("src/game/Resources/Sound/Coin_Collect_06.wav");
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

        ArrayList<collisionEvent> collide = this.move(g);
        for (collisionEvent c: collide) {
            c.getEntity().accept(this,c.getDirection());
        }



        if (push) {this.setSpeedLeft(0);}
        if (dead) { kill(g); }
    }

    //TODO: end the game
    protected void kill(game g) {
        sound sond = new sound("src/game/Resources/Sound/DeathSoundSynth.wav", false);
        sond.play();
        g.setStage("Stage_Menu");
    }

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
        String scoreBoard = "Score: " + String.valueOf(score);
        Font font = Font.font("Helvetica", FontWeight.BOLD, 30);
        canvas.setFont(font);
        canvas.setStroke(Color.WHITE);
        canvas.setLineWidth(1);
        canvas.fillText(scoreBoard, 700, 750);
        canvas.strokeText(scoreBoard, 700, 750);
    }

    @Override
    public void accept(Boost b, Direction direction) {
        int newSpeed = this.getSpeedRight() + b.getSpeedUp();
        this.setSpeedRight(newSpeed);
    }

    @Override
    public void accept(Coin c, Direction direction) {
        score += c.getValue();
        String temp = titles.get(rand.nextInt(6));
        sound sond = new sound(temp, false);
        sond.play();
         }

    @Override
    public void accept(DeathBorder D, Direction direction) { dead = true; }

    @Override
    public void accept(wall w, Direction direction) {
        //System.out.print("wall hit player from " + direction + "\n");
        if (direction.equals(Direction.LEFT)) {
            pushBack();
        } else if (direction.equals(Direction.UP)) {
            pushDown();
        } else if (direction.equals(Direction.DOWN)) {
            pushUp();
        }
    }


    public void pushBack(){
        this.setSpeedLeft(this.coreSpeed.getSpeed()+3);
        push = true;

    }

    public void pushUp(){this.takeY(this.sideSpeed);}

    public void pushDown(){
        this.addY(this.sideSpeed);
    }

    private void playerMove(game g) {
        Collide playerX = this.getCollide().clone();
        playerX.addX(coreSpeed.getSpeed());
        boolean touch = false;
        for (entity e: g.getEntityList()) {
            if(playerX.collidesWith(e)) {
                e.accept(this, Direction.LEFT);
                touch = true;
            }
        }
        if(touch) {takeX(coreSpeed.getSpeed());}
        touch = false;

        Collide playerUp = this.getCollide().clone();
        playerUp.takeY(sideSpeed);
        for (entity e: g.getEntityList()) {
            if(playerUp.collidesWith(e)) {
                e.accept(this, Direction.DOWN);
                touch = true;
            }
        }
        if(!touch) {this.takeY(getSpeedUp());}
        touch = false;

        Collide playerDown = this.getCollide().clone();
        playerX.addY(1);
        for (entity e: g.getEntityList()) {
            if(playerDown.collidesWith(e)) {
                e.accept(this, Direction.UP);
                touch = true;
            }
        }
        if(!touch) {this.addY(getSpeedDown());}

        touch = false;

        Collide playerLeft = this.getCollide().clone();
        playerLeft.addY(1);
        for (entity e: g.getEntityList()) {
            if(playerLeft.collidesWith(e)) {
                e.accept(this, Direction.RIGHT);
                touch = true;
            }
        }


    }
}
