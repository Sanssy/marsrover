package core;

public record Instruction(char instruction) {

    public char compute() {
        return this.instruction;
    }

}
