package core;

public record Vector(int x, int y) {

    public Vector reverse() {
        return new Vector(- this.x, - this.y);
    }

    public static Vector retrieveForwardTranslationFrom(Direction direction) {
        if (direction.equals(Direction.NORTH))
            return yTranslate();
        if (direction.equals(Direction.SOUTH))
            return yNegativeTranslate();
        if (direction.equals(Direction.EAST))
            return xTranslate();
        if (direction.equals(Direction.WEST))
            return xNegativeTranslate();
        return new Vector(0,0);
    }

    public static Vector retrieveBackwardTranslationFrom(Direction direction) {
        if (direction.equals(Direction.SOUTH))
            return yTranslate();
        if (direction.equals(Direction.NORTH))
            return yNegativeTranslate();
        if (direction.equals(Direction.WEST))
            return xTranslate();
        if (direction.equals(Direction.EAST))
            return xNegativeTranslate();
        return new Vector(0,0);
    }

    public static Vector xTranslate() {
        return new Vector(1,0);
    }
    public static Vector yTranslate() {
        return new Vector(0,1);
    }
    public static Vector xNegativeTranslate() {
        return xTranslate().reverse();
    }
    public static Vector yNegativeTranslate() {
        return yTranslate().reverse();
    }

}
