package core;

public enum Direction {
    NORTH("N"), SOUTH("S");

    private String value;

    Direction(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
