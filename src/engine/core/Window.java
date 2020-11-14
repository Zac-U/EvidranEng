package engine.core;

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

    String title;
    tick.game g;

    public Window(String title) {
        this.title = title;
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(this.title);
        Canvas board = new Canvas(primaryStage.getWidth(),primaryStage.getHeight());
        Group g = new Group(board);
        Scene scene = new Scene(g);
        primaryStage.setScene(scene);

        //TODO: add callbacks

        scene.setOnKeyPressed(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String code = e.getCode().toString();
                        //pass key event to game
                    }
                });

        scene.setOnMouseClicked(
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        //pass click event to game
                    }
                }
        );

        scene.setOnKeyReleased(
                new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent keyEvent) {
                        //pass event to game
                    }
                }
        );

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                //stuff to draw/tick here here
            }
        }.start();

        primaryStage.show();
    }



}
