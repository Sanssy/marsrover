package core;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Commands {
    private final List<Instruction> instructions;

    public Commands(Character... chars) {
        this.instructions = of(chars);
    }

    public List<Instruction> execute() {
        return this.instructions;
    }

    private static List<Instruction> of(Character... chars) {
        return Arrays.stream(chars).map(Instruction::new).filter(Instruction::verify).collect(Collectors.toList());
    }
}
