package core;

public enum Direction {
    SOUTH() {
        @Override
        public Direction atLeft() {
            return Direction.EAST;
        }

        @Override
        public Direction atRight() {
            return Direction.WEST;
        }
    }, NORTH {
        @Override
        public Direction atLeft() {
            return Direction.WEST;
        }

        @Override
        public Direction atRight() {
            return Direction.EAST;
        }
    }, WEST {
        @Override
        public Direction atLeft() {
            return Direction.SOUTH;
        }

        @Override
        public Direction atRight() {
            return Direction.NORTH;
        }
    }, EAST {
        @Override
        public Direction atLeft() {
            return Direction.NORTH;
        }

        @Override
        public Direction atRight() {
            return Direction.SOUTH;
        }
    };

    abstract public Direction atLeft();
    abstract public Direction atRight();

}
