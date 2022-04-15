package core;

public class Rover {

    private Position position;
    private final Direction direction;
    private Orientation orientation;
    private final Grid grid;

    public Rover(Position position, Direction direction) {
        this.grid = new Grid();
        this.position = position;
        this.direction = direction;
        this.orientation = Orientations.build(direction);
    }

    public Rover(Position position, Direction direction, Grid grid) {
        this.position = position;
        this.direction = direction;
        this.orientation = Orientations.build(direction);
        this.grid = grid;
    }

    public Position currentPosition() {
        return this.position;
    }

    public Direction currentDirection() {
        return this.direction;
    }

    public Orientation currentOrientation() {
        return this.orientation;
    }

    public void moveForward() {
        this.position = this.grid.nextPositionForward(this.position, direction);
    }

    public void moveBackward() {
        this.position = this.grid.nextPositionBackward(this.position, direction);
    }

    public void turnLeft() {
        this.orientation = this.orientation.atLeft();
    }

    public void turnRight() {
        this.orientation = this.orientation.atRight();
    }
}
