package core;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Commands {
    private final List<InstructionHandler.Instruction> instructionHandlers;

    public Commands(Character... chars) {
        this.instructionHandlers = of(chars);
    }

    public List<InstructionHandler.Instruction> execute() {
        return this.instructionHandlers;
    }

//    public List<InstructionHandler.Instruction>

    private static List<InstructionHandler.Instruction> of(Character... chars) {
        return Arrays.stream(chars)
                .map(InstructionHandler::new)
                .map(InstructionHandler::transform)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
