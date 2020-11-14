package game;

import engine.aspect.Level;
import engine.aspect.Stage;
import engine.core.GameFactory;
import engine.core.tick;

public class Main {
    public static tick.game main() {
        GameFactory maker = new GameFactory();
        player p = new player(1920/2, 1024/2,50,50);
        Level l = new Level();
        l.addEntity(p);
        l.setLastDrawn(p);
        l.addKeyPressed(p);
        l.addKeyReleased(p);
        Stage st = new Stage("Stage_One");

        st.setLevel(l);

        maker.addStage(st);

        return maker.create();

    }
}
