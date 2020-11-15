package engine;

import engine.entity.entity;
import engine.sound.sound;
import game.player;
import game.wall;

import java.util.ArrayList;

public class workbench {

    public static void main(String[] args) {
        //player P = new player(0,0);
       // wall w = new wall(77,88);

        ///ArrayList<entity> temp = new ArrayList<>();
        //temp.add(P);
        //temp.add(w);
        //System.out.print(P.collidesWith(w)+" first \n");
        //P.setSpeedRight(5);
        //P.setSpeedDown(5);
        //P.move(temp);

        sound sond;
        try {
            sond = new sound("src/game/Resources/Sound/Evidran_MainTheme.WAV", true);
            sond.play();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }




    }

}
