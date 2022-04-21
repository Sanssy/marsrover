package core;

import java.util.Map;

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

    public Position predict(Vector vector, Map<String, Integer> surface) {
        Position nextPosition = this.translate(vector);

        if (this.isOutside(nextPosition, surface))
            return this.computeEdgePositionWrapper(nextPosition, vector, surface);

        return nextPosition;
    }

    private boolean isOutside(Position position, Map<String, Integer> surface) {
        return position.y() > surface.get("MAX_HEIGHT") ||
               position.x() > surface.get("MAX_WIDTH")  ||
               position.y() < surface.get("MIN_HEIGHT") ||
               position.x() < surface.get("MIN_WIDTH");
    }

    private Position computeEdgePositionWrapper(Position currentPosition, Vector vector, Map<String, Integer> surface) {
        return switch (vector) {
            case NORTH -> Position.generate(currentPosition.x(), surface.get("MIN_HEIGHT"));
            case SOUTH -> Position.generate(currentPosition.x(), surface.get("MAX_HEIGHT"));
            case EAST -> Position.generate(surface.get("MIN_WIDTH"), currentPosition.y());
            case WEST -> Position.generate(surface.get("MAX_WIDTH"), currentPosition.y());
        };
    }
}

