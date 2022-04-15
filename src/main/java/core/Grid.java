package core;

public class Grid {
    private final int MAX_HEIGHT;
    private final int MAX_WIDTH;

    public Grid(int height, int width) {
        this.MAX_HEIGHT = height;
        this.MAX_WIDTH = width;
    }

    public Position nextPositionFor(Position position, Direction direction) {
        int x = position.x();
        int y = position.y();

        if (direction.equals(Direction.NORTH)){
            y = 0;
        }

        return new Position(x, y);
    }
}
