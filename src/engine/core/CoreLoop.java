package engine.core;

/***
 * Seperate thread class handles core game loop
 */
public class CoreLoop extends Thread{

    tick.game callee;
    boolean run = true;

    public CoreLoop(tick.game g) {
        callee = g;
    }

    @Override
    public void run() {
        try {
            //core loop here
            while(run) {

            }


        } catch(Exception e) {

        }
    }
}
