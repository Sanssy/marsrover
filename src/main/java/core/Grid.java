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

    public Position nextPositionForward(Position currentPosition, Direction direction) {
        int x = currentPosition.x();
        int y = currentPosition.y();

        y = translateUpward(direction, y, Direction.NORTH, MAX_HEIGHT);

        y = translateDownward(direction, y, Direction.SOUTH, MAX_HEIGHT);

        x = translateDownward(direction, x, Direction.WEST, MAX_WIDTH);

        x = translateUpward(direction, x, Direction.EAST, MAX_WIDTH);

        return nextPosition(currentPosition, x, y);
    }

    public Position nextPositionBackward(Position currentPosition, Direction direction) {
        int x = currentPosition.x();
        int y = currentPosition.y();

        y = translateUpward(direction, y, Direction.SOUTH, MAX_HEIGHT);

        y = translateDownward(direction, y, Direction.NORTH, MAX_HEIGHT);

        x = translateDownward(direction, x, Direction.EAST, MAX_WIDTH);

        x = translateUpward(direction, x, Direction.WEST, MAX_WIDTH);

        return nextPosition(currentPosition, x, y);
    }

    private int translateDownward(Direction direction, int coordinate, Direction expected, int grid_max_side) {
        if (direction.equals(expected))
            coordinate = applyingDownwardMovement(coordinate, grid_max_side);
        return coordinate;
    }

    private int translateUpward(Direction direction, int coordinate, Direction expected, int grid_max_side) {
        if (direction.equals(expected))
            coordinate = applyingUpwardMovement(coordinate, grid_max_side);
        return coordinate;
    }

    private Position nextPosition(Position currentPosition, int x, int y) {
        Position nextPosition = Position.generate(x, y);

         return this.obstacles.contains(nextPosition)
                ? currentPosition
                : nextPosition;
    }

    private int applyingDownwardMovement(int value, int max_side) {
        return (value > 1) ? (value - 1) : max_side;
    }

    private int applyingUpwardMovement(int value, int max_side) {
        return (value + 1) % max_side;
    }
}
