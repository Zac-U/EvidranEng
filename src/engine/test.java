package engine;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
