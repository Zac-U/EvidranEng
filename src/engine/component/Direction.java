package engine.component;

public enum Direction {
    LEFT,
    RIGHT,
    UP,
    DOWN;

    public static Direction opposite(Direction d) {
        switch (d) {
            case DOWN:
                return Direction.UP;
            case UP:
                return Direction.DOWN;
            case LEFT:
                return Direction.RIGHT;
            case RIGHT:
                return Direction.LEFT;
            default:
                return null;
        }
    }
}
