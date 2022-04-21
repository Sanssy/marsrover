package core;

import java.util.EnumMap;
import java.util.Map;

import static core.InstructionHandler.*;
import static core.InstructionHandler.Move.FORWARD;

public enum Vector {

    EAST(1,0) {
        Vector opposite() {
            return WEST;
        }
    },
    NORTH(0, 1) {
        Vector opposite() {
            return SOUTH;
        }
    },
    WEST(-1, 0) {
        Vector opposite() {
            return EAST;
        }
    },
    SOUTH(0, -1) {
        Vector opposite() {
            return NORTH;
        }
    };

    private static final Map<Direction, Vector> vectorRules = new EnumMap<>(Direction.class);

    static {
        vectorRules.put(Direction.NORTH, NORTH);
        vectorRules.put(Direction.EAST, EAST);
        vectorRules.put(Direction.SOUTH, SOUTH);
        vectorRules.put(Direction.WEST, WEST);
    }

    private final int x;
    private final int y;

    Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    abstract Vector opposite();

    public static Vector retrieveTranslationFor(Direction direction, Move instruction) {

        Vector vector = vectorRules.get(direction);

        return FORWARD.equals(instruction) ?
                vector : vector.opposite();
    }
}
