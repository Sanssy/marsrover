package core;

public record Vector(int x, int y) {

    public Vector reverse() {
        return new Vector(- this.x, - this.y);
    }

    public Vector retrieveForwardTranslationFrom(Direction direction) {
        if (direction.equals(Direction.NORTH))
            return this.xTranslate();
        if (direction.equals(Direction.SOUTH))
            return this.xNegativeTranslate();
        if (direction.equals(Direction.EAST))
            return this.yTranslate();
        if (direction.equals(Direction.WEST))
            return this.yNegativeTranslate();
        return new Vector(0,0);
    }

    public Vector xTranslate() {
        return new Vector(1,0);
    }
    public Vector yTranslate() {
        return new Vector(0,1);
    }
    public Vector xNegativeTranslate() {
        return this.xTranslate().reverse();
    }
    public Vector yNegativeTranslate() {
        return this.yTranslate().reverse();
    }

}
