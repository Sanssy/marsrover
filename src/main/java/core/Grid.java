package core;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private int MAX_HEIGHT = 10;
    private int MAX_WIDTH = 10;
    private int MIN_HEIGHT = 0;
    private int MIN_WIDTH = 0;
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

    public Position nextPosition(Position position, Direction direction, Instruction instruction) {
        Vector vector = Vector.retrieveTranslationFor(direction, instruction);
        Position nextPosition = position.predict(vector, MAX_WIDTH, MAX_HEIGHT, MIN_WIDTH, MIN_HEIGHT);

        return this.obstacles.contains(nextPosition) ? position : nextPosition;
    }
}
