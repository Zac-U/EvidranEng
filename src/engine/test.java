package engine;

import engine.component.Volume;
import engine.physics.Collide;
import engine.physics.Moveable;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class test extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Test");
        Canvas board = new Canvas(primaryStage.getWidth(),primaryStage.getHeight());
        Group g = new Group(board);
        Scene scene = new Scene(g);
        primaryStage.setScene(scene);

        Moveable va= new Moveable(0, 0, 100, 100);
        Moveable vb = new Moveable(105,105,100,100);
        boolean temp = va.collidesWith(vb);
        System.out.print(temp+" intersect\n");

        ArrayList<Moveable> temp2 = new ArrayList<>();

        temp2.add(va);
        temp2.add(vb);

        vb.setSpeedLeft(5);
        vb.setSpeedUp(5);
        vb.move(temp2, true);

        //TODO: add callbacks

        scene.setOnKeyPressed(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        System.out.print(e.getCharacter()+"\n");
                        System.out.print(e.getCode()+"\n");
                    }
                });

        scene.setOnMouseClicked(
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        System.out.print(mouseEvent.toString()+"\n");
                    }
                }
        );

        scene.setOnKeyReleased(
                new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent keyEvent) {
                       System.out.print(keyEvent.getCharacter()+"\n");
                    }
                }
        );

        primaryStage.show();

    }
}
