package engine.core;

import engine.aspect.Stage;

import java.util.Set;

public interface tick {

    void tick(game g);

    public interface game {

        Stage getCurrentStage();
        Set<Stage> getSetList();
        void setCurrentStage(Stage s);
        void addStage(Stage s);


    }

}
