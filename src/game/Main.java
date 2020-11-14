package game;

import engine.aspect.Level;
import engine.aspect.Stage;
import engine.core.GameFactory;
import engine.core.tick;

public class Main {
    public static tick.game main() {
        GameFactory maker = new GameFactory();
        player p = new player(500, 500,50,50);
        wall w = new wall(1000,10);
        Level l = new Level();
        l.addEntity(p);
        l.setLastDrawn(p);
        l.addKeyPressed(p);
        l.addKeyReleased(p);
        l.addEntity(w);
        Stage st = new Stage("Stage_One");

        st.setLevel(l);

        maker.addStage(st);
        maker.setStartStage(st);

        return maker.create();

    }
}
