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
        this.position = new Position(this.position.x(), this.position.y() +1);
    }
}
