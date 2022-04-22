package core;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    static class Surface {
        public final int MAX_HEIGHT;
        public final int MAX_WIDTH;
        public final int MIN_HEIGHT;
        public final int MIN_WIDTH;

        public Surface(int height, int width) {
            MAX_HEIGHT = height;
            MAX_WIDTH = width;
            MIN_HEIGHT = 0;
            MIN_WIDTH = 0;
        }

        public Surface() {
            this(10, 10);
        }

    }

    private Grid.Surface surface = new Surface();
    private List<Position> obstacles = new ArrayList<>();

    public Grid() {}

    public Grid(int height, int width) {
        surface = new Surface(height, width);
    }

    public Grid(List<Position> obstacles) {
        this.obstacles = obstacles;
    }

    public Position nextPosition(Position currentPosition, Direction direction, Instruction.Move move) {
        Vector vector = Vector.retrieveTranslationFor(direction, move);
        Position nextPosition = this.predict(currentPosition, vector);

        return this.obstacles.contains(nextPosition) ? currentPosition : nextPosition;
    }

    private Position predict(Position currentPosition, Vector vector) {
        Position nextPosition = currentPosition.translate(vector);
        return this.contains(nextPosition) ?
                nextPosition :
                this.computeEdgePositionWrapper(nextPosition, vector);
    }

    private Position computeEdgePositionWrapper(Position currentPosition, Vector vector) {
        return switch (vector) {
            case NORTH -> Position.generate(currentPosition.x(), surface.MIN_HEIGHT);
            case SOUTH -> Position.generate(currentPosition.x(), surface.MAX_HEIGHT);
            case EAST -> Position.generate(surface.MIN_WIDTH, currentPosition.y());
            case WEST -> Position.generate(surface.MAX_WIDTH, currentPosition.y());
        };
    }

    private boolean contains(Position position) {
        return !(position.y() > surface.MAX_HEIGHT ||
                position.x() > surface.MAX_WIDTH  ||
                position.y() < surface.MIN_HEIGHT ||
                position.x() < surface.MIN_WIDTH);
    }
}
