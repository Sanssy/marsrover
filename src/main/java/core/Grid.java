package core;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private int MAX_HEIGHT = 10;
    private int MAX_WIDTH = 10;
    private List<Position> obstacles = new ArrayList<>();

    public Grid() {

    }

    public Grid(int height, int width) {
        this.MAX_HEIGHT = height;
        this.MAX_WIDTH = width;
    }

    public Grid(List<Position> obstacles) {
        this.obstacles = obstacles;
    }

    public Grid(int MAX_HEIGHT, int MAX_WIDTH, List<Position> obstacles) {
        this.MAX_HEIGHT = MAX_HEIGHT;
        this.MAX_WIDTH = MAX_WIDTH;
        this.obstacles = obstacles;
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

        Position nextPosition = new Position(x, y);

        return this.obstacles.contains(nextPosition)
                ? currentPosition
                : nextPosition;
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
