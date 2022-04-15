package core;

public class Grid {
    private int MAX_HEIGHT = 10;
    private int MAX_WIDTH = 10;

    public Grid() {

    }

    public Grid(int height, int width) {
        this.MAX_HEIGHT = height;
        this.MAX_WIDTH = width;
    }

    public Position nextPositionForward(Position currentPosition, Direction direction) {
        int x = currentPosition.x();
        int y = currentPosition.y();

        if (direction.equals(Direction.NORTH)){
            y = applyingUpwardMovement(y, MAX_HEIGHT);
        }

        if (direction.equals(Direction.SOUTH)){
            y = applyingDownwardMovement(y, MAX_HEIGHT);
        }

        if (direction.equals(Direction.WEST)){
            x = applyingDownwardMovement(x, MAX_WIDTH);
        }

        if (direction.equals(Direction.EAST)){
            x = applyingUpwardMovement(x, MAX_WIDTH);
        }

        return new Position(x, y);
    }

    public Position nextPositionBackward(Position currentPosition, Direction direction) {
        int x = currentPosition.x();
        int y = currentPosition.y();

        if (direction.equals(Direction.SOUTH)){
            y = applyingUpwardMovement(y, MAX_HEIGHT);
        }

        if (direction.equals(Direction.NORTH)){
            y = applyingDownwardMovement(y, MAX_HEIGHT);
        }

        if (direction.equals(Direction.EAST)){
            x = applyingDownwardMovement(x, MAX_WIDTH);
        }

        if (direction.equals(Direction.WEST)){
            x = applyingUpwardMovement(x, MAX_WIDTH);
        }

        return new Position(x, y);
    }

    private int applyingDownwardMovement(int value, int max_side) {
        return (value > 1) ? (value - 1) : max_side;
    }

    private int applyingUpwardMovement(int value, int max_side) {
        return (value + 1) % max_side;
    }
}
