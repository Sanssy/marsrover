package core;

public class Rover {

    private Position position;

    public Rover(Position position) {
        this.position = position;
    }

    public Position currentPosition() {
        return this.position;
    }
}
