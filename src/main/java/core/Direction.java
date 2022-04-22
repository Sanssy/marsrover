package core;

import static core.Instruction.Rotation.LEFT;

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

    public Direction rotate(Instruction.Rotation rotation) {
        return LEFT.equals(rotation) ?
                this.atLeft() : this.atRight();
    }

    abstract Direction atRight();
    abstract Direction atLeft();
}
