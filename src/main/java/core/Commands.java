package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Commands {
    private List<Instruction> instructions;

    public Commands() {
        this.instructions = new ArrayList<>();
    }

    public List<Instruction> execute() {
        return this.instructions;
    }

    public void generate(Instruction... instructions) {
        this.instructions = Arrays.stream(instructions).filter(Instruction::verify).toList();
    }
}
