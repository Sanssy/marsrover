package core;

public class Rover {

    private Position position;
    private Direction direction;

    public Rover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Position currentPosition() {
        return this.position;
    }

    public Direction currentDirection() {
        return this.direction;
    }

    public String fullLocation() {
        return ""+position.x()+":"+position.y()+":"+direction.getValue();
    }

    public void moveForward() {
        if (this.direction.equals(Direction.NORTH))
            this.position = this.position.translate(0, 1);
        if (this.direction.equals(Direction.SOUTH))
            this.position = this.position.translate(0, -1);
        if (this.direction.equals(Direction.EAST))
            this.position = this.position.translate(1, 0);
    }
}
