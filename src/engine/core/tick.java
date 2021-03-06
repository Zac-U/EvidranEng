package engine.core;

import engine.aspect.Level;
import engine.aspect.Stage;
import engine.draw.drawable;
import engine.entity.entity;
import engine.event.windowEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.Set;

public interface tick {

    void tick(game g);

    public interface game extends drawable {

        Stage getCurrentStage();
        Set<Stage> getSetList();
        void setCurrentStage(Stage s);
        void addStage(Stage s);
        void passInputEvent(windowEvent e);
        void update();
        void draw(Canvas board);
        ArrayList<entity> getEntityList();
        Level getLevel();
        // REVIEW:
        void setGameSpeed(int speed);
        void setStage(String name);
        void kill(entity e);
    }

}
