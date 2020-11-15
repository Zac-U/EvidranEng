package engine.core;

import engine.component.Location;
import engine.event.windowEvent;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.Group;

public class Window extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    private windowEvent getEvent(String evt, String key) {
       return new windowEvent(evt, key);
    }

    private windowEvent getEvent(String evt, Location key) {
        return new windowEvent(evt, key);
    }

    @Override
    public void start(Stage primaryStage) {

        tick.game Gam = game.Main.main();

        primaryStage.setTitle("Evidran");
        Canvas board = new Canvas(1920,1080);
        Group gu = new Group(board);
        Scene scene = new Scene(gu);
        primaryStage.setScene(scene);


        scene.setOnKeyPressed(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String code = e.getCode().toString();
                        Gam.passInputEvent(getEvent("KEYPRESSED", code));//game called here
                    }
                });

        scene.setOnMouseClicked(
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                       int tempX = (int) mouseEvent.getX();
                       int tempY = (int) mouseEvent.getY();
                       System.out.print("\t"+tempX+" "+ tempY+"\n");
                       Location temp = new Location(tempX, tempY);
                        Gam.passInputEvent(getEvent("MOUSEPRESSED", temp));//game called here
                    }
                }
        );

        scene.setOnKeyReleased(
                new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent keyEvent) {
                        String code = keyEvent.getCode().toString();
                        Gam.passInputEvent(getEvent("KEYRELEASED", code));//game called here
                    }
                }
        );



        new AnimationTimer()
        {
            int count = 0;
            int gameSpeed = 1;
            long startTime = System.currentTimeMillis();
            public void handle(long currentNanoTime)
            {
                count++;
                GraphicsContext temp = board.getGraphicsContext2D();
                temp.setFill(Color.BLACK);
                temp.fillRect(0,0,1920,1080);
                Gam.draw(temp);

                long secsElapsed = (System.currentTimeMillis() - startTime) / 1000;
                int newSpeed = Math.floorDiv((int) (secsElapsed), 10) + 1;
                if (newSpeed != gameSpeed) {
                    gameSpeed = newSpeed;
                    Gam.setGameSpeed(gameSpeed);//game called here
                }

                if((count % 2) == 0) {Gam.update();}
                if(count >= 60) {count = 0;}
            }
        }.start();

        primaryStage.show();
    }



}
