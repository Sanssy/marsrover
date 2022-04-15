package core;

public class Grid {
    private int MAX_HEIGHT = 10;
    private int MAX_WIDTH = 10;

    public Grid(int height, int width) {
        this.MAX_HEIGHT = height;
        this.MAX_WIDTH = width;
    }

    public Grid() {

    }

    public Position nextPositionForward(Position currentPosition, Direction direction) {
        int x = currentPosition.x();
        int y = currentPosition.y();

        if (direction.equals(Direction.NORTH)){
            y = (y + 1) % MAX_HEIGHT;
        }

        if (direction.equals(Direction.SOUTH)){
            y = (y > 1) ? (y - 1) : MAX_HEIGHT;
        }

        if (direction.equals(Direction.WEST)){
            x = (x > 1) ? (x - 1) : MAX_WIDTH;
        }

        if (direction.equals(Direction.EAST)){
            x = (x + 1) % MAX_WIDTH;
        }

        return new Position(x, y);
    }

    public Position nextPositionBackward(Position currentPosition, Direction direction) {
        int x = currentPosition.x();
        int y = currentPosition.y();

        if (direction.equals(Direction.SOUTH)){
            y = (y + 1) % MAX_HEIGHT;
        }

        if (direction.equals(Direction.NORTH)){
            y = (y > 1) ? (y - 1) : MAX_HEIGHT;
        }

        if (direction.equals(Direction.EAST)){
            x = (x > 1) ? (x - 1) : MAX_WIDTH;
        }

        if (direction.equals(Direction.WEST)){
            x = (x + 1) % MAX_WIDTH;
        }

        return new Position(x, y);
    }
}
