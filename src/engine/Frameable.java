package engine;

public class Frameable extends Locateable {
    boolean inframe;
    public Frameable(int x, int y) {
        super(x,y);
    }

    public class Frame extends Volumeable {
        public Frame(int x, int y, int volX, int volY) {
            super(x,y,volX,volY);
        }
    }


}
