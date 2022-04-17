package core;

import java.util.List;

public class Commands {
    private List<Instruction> instructions;

    public Commands() {
    }

    public List<Instruction> execute() {
        return this.instructions;
    }

    public void generate(Instruction... instructions) {
        this.instructions = List.of(instructions);
    }
}
