package core;

public record Position(int x, int y) {
    private Position translate(int x, int y) {
        return new Position(this.x + x, this.y + y);
    }

    public Position translate(Vector vector) {
        return translate(vector.x(), vector.y());
    }

    public static Position generate(int x, int y) {
        return new Position(x,y);
    }

    public Position predict(Vector vector, Grid.Surface surface) {
        Position nextPosition = this.translate(vector);

        if (this.isOutside(nextPosition, surface))
            return this.computeEdgePositionWrapper(nextPosition, vector, surface);

        return nextPosition;
    }

    private boolean isOutside(Position position,  Grid.Surface surface) {
        return position.y() > surface.MAX_HEIGHT ||
               position.x() > surface.MAX_WIDTH  ||
               position.y() < surface.MIN_HEIGHT ||
               position.x() < surface.MIN_WIDTH;
    }

    private Position computeEdgePositionWrapper(Position currentPosition, Vector vector, Grid.Surface surface) {
        return switch (vector) {
            case NORTH -> Position.generate(currentPosition.x(), surface.MIN_HEIGHT);
            case SOUTH -> Position.generate(currentPosition.x(), surface.MAX_HEIGHT);
            case EAST -> Position.generate(surface.MIN_WIDTH, currentPosition.y());
            case WEST -> Position.generate(surface.MAX_WIDTH, currentPosition.y());
        };
    }
}

