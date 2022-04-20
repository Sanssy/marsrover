package core;

import java.util.EnumMap;
import java.util.Map;

import static core.InstructionHandler.*;

public record Vector(int x, int y) {

    private static Vector east() {
        return new Vector(1,0);
    }
    private static Vector north() {
        return new Vector(0,1);
    }
    private static Vector west() {
        return east().reverse();
    }
    private static Vector south() {
        return north().reverse();
    }
    private static Vector abort() { return new Vector(0,0); }

    private static final Map<Direction, Vector> vectorRules = new EnumMap<>(Direction.class);

    static {
        vectorRules.put(Direction.NORTH, north());
        vectorRules.put(Direction.EAST, east());
        vectorRules.put(Direction.SOUTH, south());
        vectorRules.put(Direction.WEST, west());
    }

    public static Vector retrieveTranslationFor(Direction direction, Instruction instruction) {

        Vector vector = vectorRules.get(direction);

        return Instruction.FORWARD.equals(instruction) ?
                vector : Instruction.BACKWARD.equals(instruction) ?
                vector.reverse() : abort();
    }

    public Vector reverse() {
        return new Vector(- this.x, - this.y);
    }
}
