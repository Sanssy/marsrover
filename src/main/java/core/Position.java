package core;

public record Position(int x, int y) {
    public Position translate(int x, int y) {
        return new Position(this.x + x, this.y + y);
    }

    public Position translate(Vector vector) {
        return translate(vector.x(), vector.y());
    }
}

