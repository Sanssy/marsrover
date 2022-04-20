package core;

public record Position(int x, int y) {
    public Position translate(int x, int y) {
        return new Position(this.x + x, this.y + y);
    }

    public Position translate(Vector vector) {
        return translate(vector.x(), vector.y());
    }

    public static Position generate(int x, int y) {
        return new Position(x,y);
    }

    public Position predict(Vector vector, int max_width, int max_height, int min_width, int min_height) {
        Position nextPosition = this.translate(vector);

        if (this.isOutsideByEast(nextPosition, max_width))
            return Position.generate(this.x() % max_width, this.y());

        if (this.isOutsideByWest(nextPosition, min_width))
            return Position.generate(max_width, this.y());

        if (this.isOutsideByNorth(nextPosition, max_height))
            return Position.generate(this.x(), this.y() % max_height);

        if (this.isOutsideBySouth(nextPosition, min_height))
            return Position.generate(this.x(), max_height);

        return nextPosition;
    }

    private boolean isOutsideByEast(Position position, int max_width) {
        return position.x() > max_width;
    }

    private boolean isOutsideByWest(Position position, int min_width) {
        return position.x() < min_width;
    }

    private boolean isOutsideByNorth(Position position, int max_height) {
        return position.y() > max_height;
    }

    private boolean isOutsideBySouth(Position position, int min_height) {
        return position.y() < min_height;
    }
}

