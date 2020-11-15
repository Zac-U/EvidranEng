package game;

import engine.aspect.Level;
import engine.aspect.Stage;
import engine.core.GameFactory;
import engine.core.tick;
import engine.sound.sound;
import game.Menu.Button;
import game.Menu.SimpleGraphic;

public class Main {
    public static tick.game main() {
        GameFactory maker = new GameFactory();

        //Make game stage/level
        Level lvlGame = new Level();
        Stage stGame = new Stage("Stage_One");
        //Create level entities
        player p = new player(500, 500,lvlGame.getSpeed());
        wall w = new wall(1000,10,lvlGame.getSpeed());
        DeathBorder d = new DeathBorder(0,0,52,1080,lvlGame.getSpeed());
        Background bg = new Background(lvlGame.getSpeed());
        Coin c = new Coin(1500, 500, 39, 40, lvlGame.getSpeed());
        //Add entities to level
        lvlGame.addEntity(p);
        lvlGame.setLastDrawn(p);
        lvlGame.addKeyPressed(p);
        lvlGame.addKeyReleased(p);
        lvlGame.addEntity(w);
        lvlGame.addMid(w);
        lvlGame.addEntity(c);
        lvlGame.addMid(c);
        lvlGame.addEntity(d);
        lvlGame.addMid(d);
        lvlGame.addEntity(bg);
        lvlGame.addBackground(bg);
        sound sond = new sound("src/game/Resources/Sound/Evidran_MainTheme.WAV", true);
        lvlGame.track = sond;
        sond.play();

        stGame.setLevel(lvlGame);

        //Make Main menu stage/level
        Level lvlMenu = new Level();
        Stage stMenu = new Stage("Stage_Menu");
        //Create level entities
        Button btnPlay = new Button(500, 500, 100, 100,lvlGame.getSpeed());
        btnPlay.setText("Play");
        btnPlay.setNextStage(stGame);
        SimpleGraphic title = new SimpleGraphic(0, 0, 1920, 1080, "file:src/game/Resources/Graphics/1080p/gph_titleScreen.png",lvlGame.getSpeed());
        //Add entities to level
        lvlMenu.addEntity(btnPlay);
        lvlMenu.setLastDrawn(btnPlay);
        lvlMenu.addEntity(bg);
        lvlMenu.addBackground(bg);
        lvlMenu.addEntity(title);
        lvlMenu.addMid(title);
        lvlMenu.addKeyReleased(btnPlay);

        stMenu.setLevel(lvlGame);

        //Add stages/levels to Game
        maker.addStage(stMenu);
        maker.addStage(stGame);

        maker.setStartStage(stMenu);

        return maker.create();

    }

}
