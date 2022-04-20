package core;

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

    public static Vector retrieveTranslationFor(Direction direction, Instruction instruction) {

        if (instructionAreSettingAt(direction, instruction, Direction.NORTH, Direction.SOUTH))
            return north();
        if (instructionAreSettingAt(direction, instruction, Direction.SOUTH, Direction.NORTH))
            return south();
        if (instructionAreSettingAt(direction, instruction, Direction.EAST, Direction.WEST))
            return east();
        if (instructionAreSettingAt(direction, instruction, Direction.WEST, Direction.EAST))
            return west();
        return abort();
    }

    private static boolean instructionAreSettingAt(Direction currentDirection, Instruction instruction, Direction directionF, Direction directionB) {
        return currentDirection.equals(directionF) && instruction.value() == Instruction.ValidInstruction.FORWARD.value ||
               currentDirection.equals(directionB) && instruction.value() == Instruction.ValidInstruction.BACKWARD.value;
    }

    public Vector reverse() {
        return new Vector(- this.x, - this.y);
    }
}
