package core;

import java.util.EnumMap;

public class Orientations {

    static EnumMap<Direction, Orientation> directionRules;

    static void Orientations_init() {
        directionRules = new EnumMap<>(Direction.class);
        directionRules.put(Direction.NORTH, new North());
        directionRules.put(Direction.EAST, new East());
        directionRules.put(Direction.SOUTH, new South());
        directionRules.put(Direction.WEST, new West());
    }

    public static Orientation build(Direction direction) {
        Orientations_init();
        return directionRules.get(direction);
    }

    private record North() implements Orientation {

        public Orientation atLeft() {
            return new East();
        }
    }

    private record East() implements Orientation {

        public Orientation atLeft() {
            return new South();
        }
    }

    private record South() implements Orientation {

        public Orientation atLeft() { return new West(); }
    }

    private record West() implements Orientation {

        public Orientation atLeft() {
            return new North();
        }
    }
}
