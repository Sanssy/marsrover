package core;

public enum Direction {
    SOUTH {
        private Direction atLeft() {
            return Direction.EAST;
        }

        private Direction atRight() {
            return Direction.WEST;
        }

        @Override
        public Direction turn(Instruction instruction) {
            if (instruction.value() == Instruction.ValidInstruction.LEFT.value)
                return this.atLeft();
            return this.atRight();
        }
    }, NORTH {
        private Direction atLeft() {
            return Direction.WEST;
        }

        private Direction atRight() {
            return Direction.EAST;
        }

        @Override
        public Direction turn(Instruction instruction) {
            if (instruction.value() == Instruction.ValidInstruction.LEFT.value)
                return this.atLeft();
            return this.atRight();
        }
    }, WEST {
        private Direction atLeft() {
            return Direction.SOUTH;
        }

        private Direction atRight() {
            return Direction.NORTH;
        }

        @Override
        public Direction turn(Instruction instruction) {
            if (instruction.value() == Instruction.ValidInstruction.LEFT.value)
                return this.atLeft();
            return this.atRight();
        }
    }, EAST {
        private Direction atLeft() {
            return Direction.NORTH;
        }

        private Direction atRight() {
            return Direction.SOUTH;
        }

        @Override
        public Direction turn(Instruction instruction) {
            if (instruction.value() == Instruction.ValidInstruction.LEFT.value)
                return this.atLeft();
            return this.atRight();
        }
    };

    public abstract Direction turn(Instruction instruction);
}
