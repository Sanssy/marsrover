package core;

import java.util.List;

public class Rover {

    private Position position;
    private Direction direction;
    private final Orientation orientation;
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
        this.position = this.grid.nextPositionForward(this.position, this.direction);
    }

    public void moveBackward() {
        this.position = this.grid.nextPositionBackward(this.position, direction);
    }

    public void turnLeft() {
        this.direction = this.direction.atLeft();
    }

    public void turnRight() {
        this.direction = this.direction.atRight();
    }

    public void execute(String[] characters) {
        for (String characters1 : List.of(characters)) {
            if (characters1.equals("f")) {
                this.moveForward();
            }
            if (characters1.equals("b")) {
                this.moveBackward();
            }
            if (characters1.equals("l")) {
                this.turnLeft();
            }
            if (characters1.equals("r")) {
                this.turnRight();
            }
        }
    }
}
