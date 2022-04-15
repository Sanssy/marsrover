package core;

import java.util.EnumMap;

public class Rover {

    private Position position;
    private Direction direction;
    private Orientation orientation;

    static EnumMap<Direction, Vector> movingRules;

    Rover() {
        movingRules = new EnumMap<>(Direction.class);
        movingRules.put(Direction.NORTH, new Vector(0, 1));
        movingRules.put(Direction.EAST, new Vector(1, 0));
        movingRules.put(Direction.SOUTH, new Vector(0, -1));
        movingRules.put(Direction.WEST, new Vector(-1, 0));
    }

    public Rover(Position position, Direction direction) {
        this();
        this.position = position;
        this.direction = direction;
        this.orientation = Orientations.build(direction);
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
        Vector vector = movingRules.get(this.direction);
        this.position = this.position.translate(vector);
    }

    public void moveBackward() {
        Vector vector = movingRules.get(this.direction);
        this.position = this.position.translate(vector.reverse());
    }

    public void turnLeft() {
        this.orientation = this.orientation.atLeft();
    }

    public void turnRight() {
        this.orientation = this.orientation.atRight();
    }
}
