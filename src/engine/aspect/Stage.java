package engine.aspect;

import engine.component.Volume;

/***
 * A Stage is an aspect of a game, basicaly a screen, whether that's the menu or the level
 * it has a set of buttons and a set of levels
 * also has a level frame which is an object that holds a level and all it's associated objects
 */
public class Stage {

    public class LevelFrame extends Volume {

        public LevelFrame(Volume v) {
            super(v);
        }

    }

}
