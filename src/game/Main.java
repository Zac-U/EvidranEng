package game;

import engine.aspect.Level;
import engine.aspect.Stage;
import engine.core.GameFactory;
import engine.core.tick;
import game.Menu.Button;
import game.Menu.SimpleGraphic;

public class Main {
    public static tick.game main() {
        GameFactory maker = new GameFactory();

        //Make game stage/level
        Level lvlGame = new Level();
        Stage stGame = new Stage("Stage_One");
        //Create level entities
        player p = new player(500, 500);
        wall w = new wall(1000,10);
        DeathBorder d = new DeathBorder(0,0,52,1080);
        Background bg = new Background();
        //Add entities to level
        lvlGame.addEntity(p);
        lvlGame.setLastDrawn(p);
        lvlGame.addKeyPressed(p);
        lvlGame.addKeyReleased(p);
        lvlGame.addEntity(w);
        lvlGame.addMid(w);
        lvlGame.addEntity(d);
        lvlGame.addMid(d);
        lvlGame.addEntity(bg);
        lvlGame.addBackground(bg);

        stGame.setLevel(lvlGame);

        //Make Main menu stage/level
        Level lvlMenu = new Level();
        Stage stMenu = new Stage("Stage_Menu");
        //Create level entities
        Button btnPlay = new Button(500, 500, 100, 100);
        btnPlay.setText("Play");
        btnPlay.setNextStage(stGame);
        SimpleGraphic title = new SimpleGraphic(0, 0, 1920, 1080, "file:src/game/Resources/Graphics/1080p/gph_titleScreen.png");
        //Add entities to level
        lvlMenu.addEntity(btnPlay);
        lvlMenu.setLastDrawn(btnPlay);
        lvlMenu.addEntity(bg);
        lvlMenu.addBackground(bg);
        lvlMenu.addEntity(title);
        lvlMenu.addMid(title);

        stMenu.setLevel(lvlMenu);

        //Add stages/levels to Game
        maker.addStage(stMenu);
        maker.addStage(stGame);

        maker.setStartStage(stGame);

        return maker.create();

    }

    public static int getSpeed(){ return 5;}
}
