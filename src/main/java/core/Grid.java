package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static core.InstructionHandler.*;

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

    public Map<String, Integer> surface() {
        return new HashMap<>() {
            { put("MAX_HEIGHT", MAX_HEIGHT); }
            { put("MAX_WIDTH", MAX_WIDTH); }
            { put("MIN_HEIGHT", MIN_HEIGHT); }
            { put("MIN_WIDTH", MIN_WIDTH); }
        };
    }

    public Position nextPosition(Position currentPosition, Direction direction, Instruction instruction) {
        Vector vector = Vector.retrieveTranslationFor(direction, instruction);
        Position nextPosition = currentPosition.predict(vector, this.surface());

        return this.obstacles.contains(nextPosition) ? currentPosition : nextPosition;
    }
}
