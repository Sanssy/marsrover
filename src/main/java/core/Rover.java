package core;

import static core.InstructionHandler.*;

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
        for (Instruction instruction : commands.execute()) {
            if (instruction instanceof Move) {
                this.move((Move) instruction);
            } else if (instruction instanceof Rotate) {
                this.turn((Rotate) instruction);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public void move(Move instruction) {
        this.position = this.grid.nextPosition(this.position, this.direction, instruction);
    }

    public void turn(Rotate instruction) {
        this.direction = this.direction.turn(instruction);
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
