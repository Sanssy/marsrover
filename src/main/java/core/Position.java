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

    public Position predict(Vector vector, Grid grid, Grid.Surface surface) {
        Position nextPosition = this.translate(vector);

        return grid.contains(nextPosition) ?
                nextPosition :
                this.computeEdgePositionWrapper(vector, surface);
    }

    private Position computeEdgePositionWrapper(Vector vector, Grid.Surface surface) {
        return switch (vector) {
            case NORTH -> Position.generate(this.x(), surface.MIN_HEIGHT);
            case SOUTH -> Position.generate(this.x(), surface.MAX_HEIGHT);
            case EAST -> Position.generate(surface.MIN_WIDTH, this.y());
            case WEST -> Position.generate(surface.MAX_WIDTH, this.y());
        };
    }
}

