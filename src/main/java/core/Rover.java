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

    public Position currentPosition() {
        return this.position;
    }

    public Direction currentDirection() {
        return this.direction;
    }

    public void moveForward() {
        this.position = this.grid.nextPositionForward(this.position, this.direction);
    }

    public void moveBackward() {
        this.position = this.grid.nextPositionBackward(this.position, this.direction);
    }

    public void turnLeft() {
        this.direction = this.direction.atLeft();
    }

    public void turnRight() {
        this.direction = this.direction.atRight();
    }

    public void apply(Commands commands) {
        for (Instruction instruction : commands.execute()) {
            switch (instruction.compute()) {
                case 'f' -> this.moveForward();
                case 'b' -> this.moveBackward();
                case 'l' -> this.turnLeft();
                case 'r' -> this.turnRight();
                default -> {
                    return;
                }
            }
        }
    }

    public String state() {
        return "Command execution aborted due to an obstacle, my current position is " + this.currentPosition();
    }
}
