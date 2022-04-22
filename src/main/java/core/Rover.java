package core;

public class Rover {

    private Position position;
    private Direction direction;
    private final Grid grid;

    public Rover(Position position, Direction direction) {
        this.grid = new Grid();
        this.position = position;
        this.direction = direction;
    }

    public Rover(Position position, Direction direction, Grid grid) {
        this.position = position;
        this.direction = direction;
        this.grid = grid;
    }

    public void apply(Commands commands) {
        for (Instruction instruction : commands.validInstructions()) {
            if (instruction instanceof Instruction.Move)
                this.move((Instruction.Move) instruction);

            if (instruction instanceof Instruction.Rotation)
                this.rotate((Instruction.Rotation) instruction);
        }
    }

    public void move(Instruction.Move move) {
        this.position = this.grid.nextPosition(this.position, this.direction, move);
    }

    public void rotate(Instruction.Rotation toward) {
        this.direction = this.direction.rotate(toward);
    }

    public Position currentPosition() {
        return this.position;
    }

    public Direction currentDirection() {
        return this.direction;
    }

    public String state() {
        return "Command execution aborted due to an obstacle. My current position is "
                + this.currentPosition() + " facing " + this.currentDirection().name() + " direction";
    }
}
