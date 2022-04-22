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

    public Grid() {
    }

    public Grid(int height, int width) {
        surface = new Surface(height, width);
    }

    public Grid(List<Position> obstacles) {
        this.obstacles = obstacles;
    }

    public boolean contains(Position position) {
        return !(position.y() > surface.MAX_HEIGHT ||
                position.x() > surface.MAX_WIDTH  ||
                position.y() < surface.MIN_HEIGHT ||
                position.x() < surface.MIN_WIDTH);
    }

    public Position nextPosition(Position currentPosition, Direction direction, Instruction.Move move) {
        Vector vector = Vector.retrieveTranslationFor(direction, move);
        Position nextPosition = currentPosition.predict(vector, this,this.surface);

        return this.obstacles.contains(nextPosition) ? currentPosition : nextPosition;
    }
}
