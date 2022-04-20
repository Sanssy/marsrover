package core;

import static core.InstructionHandler.*;

public enum Direction {
    SOUTH {
        public Direction atLeft() {
            return Direction.EAST;
        }

        public Direction atRight() {
            return Direction.WEST;
        }

    }, NORTH {
        public Direction atLeft() {
            return Direction.WEST;
        }

        public Direction atRight() {
            return Direction.EAST;
        }

    }, WEST {
        public Direction atLeft() {
            return Direction.SOUTH;
        }

        public Direction atRight() {
            return Direction.NORTH;
        }

    }, EAST {
        public Direction atLeft() {
            return Direction.NORTH;
        }

        public Direction atRight() {
            return Direction.SOUTH;
        }

    };

    public Direction turn(Instruction instruction) {
        return Instruction.LEFT.equals(instruction) ? this.atLeft() : this.atRight();
    }
    abstract Direction atRight();
    abstract Direction atLeft();
}
