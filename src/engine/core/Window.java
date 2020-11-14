package engine.core;

import javafx.application.Application;
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

    Canvas board = new Canvas();
    Stage core;
    String title;

    public Window(String title) {
        this.title = title;
    }

    public Canvas getCanvas(){return this.board;}

    public void render() {core.show();}

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        core = primaryStage;
        core.setTitle(this.title);
        Group g = new Group(board);
        Scene scene = new Scene(g);
        core.setScene(scene);
        core.show();
        //TODO: add callbacks

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println("Hello World");

            }
        };

    }



}
