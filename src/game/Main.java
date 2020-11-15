package game;

import engine.aspect.Level;
import engine.aspect.Stage;
import engine.core.GameFactory;
import engine.core.tick;
import game.Menu.Button;

public class Main {
    public static tick.game main() {
        GameFactory maker = new GameFactory();
        player p = new player(500, 500);
        wall w = new wall(1000,10);
        Level l = new Level();
        DeathBorder d = new DeathBorder(0,0,52,1080);
        Background bg = new Background();
        l.addEntity(p);
        l.setLastDrawn(p);
        l.addKeyPressed(p);
        l.addKeyReleased(p);
        l.addEntity(w);
        l.addMid(w);
        l.addEntity(d);
        l.addMid(d);
        l.addEntity(bg);
        l.addBackground(bg);
        Stage st = new Stage("Stage_One");

        st.setLevel(l);

        Level lvlMenu = new Level();
        Button btnPlay = new Button(0, 0, 10, 10);
        lvlMenu.addEntity(btnPlay);
        lvlMenu.addMid(btnPlay);
        l.addEntity(bg);
        l.addBackground(bg);
        Stage stMenu = new Stage("Stage_Menu");
        stMenu.setLevel(lvlMenu);


        maker.addStage(st);
        maker.addStage(stMenu);
        maker.setStartStage(st);

        return maker.create();

    }
}
