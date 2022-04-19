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
        Vector vector = Vector.retrieveForwardTranslationFrom(direction);

        return nextPosition(currentPosition, vector);
    }

    public Position nextPositionBackward(Position currentPosition, Direction direction) {
        Vector vector = Vector.retrieveBackwardTranslationFrom(direction);

        return nextPosition(currentPosition, vector);
    }

    private Position nextPosition(Position currentPosition, Vector vector) {
        Position nextPosition = currentPosition.translate(vector);

        if (this.xIsOutOfMapPositively(nextPosition)) {
            nextPosition = Position.generate(currentPosition.x() % MAX_WIDTH, currentPosition.y());
        } else if (this.xIsOutOfMapNegatively(nextPosition)) {
            nextPosition = Position.generate(MAX_WIDTH, currentPosition.y());
        } else if (this.yIsOutOfMapPositively(nextPosition)) {
            nextPosition = Position.generate(currentPosition.x(), currentPosition.y() % MAX_HEIGHT);
        } else if (this.yIsOutOfMapNegatively(nextPosition)){
            nextPosition = Position.generate(currentPosition.x(), MAX_HEIGHT);
        }

        return this.obstacles.contains(nextPosition)
                ? currentPosition
                : nextPosition;
    }

    private boolean xIsOutOfMapPositively(Position position) {
        return position.x() > MAX_HEIGHT;
    }

    private boolean xIsOutOfMapNegatively(Position position) {
        int MIN_HEIGHT = 0;
        return position.x() < MIN_HEIGHT;
    }

    private boolean yIsOutOfMapPositively(Position position) {
        return position.y() > MAX_WIDTH;
    }

    private boolean yIsOutOfMapNegatively(Position position) {
        int MIN_WIDTH = 0;
        return position.y() < MIN_WIDTH;
    }
}
