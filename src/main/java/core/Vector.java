package core;

public record Vector(int x, int y) {
    public Vector reverse() {
        return new Vector(- this.x, - this.y);
    }
}
