package engine.core;

import engine.aspect.Level;
import engine.aspect.Stage;
import engine.draw.drawable;
import engine.entity.entity;
import engine.event.windowEvent;

import java.awt.*;
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
        Set<entity> getEntityList();
        Level getLevel();

    }

}
