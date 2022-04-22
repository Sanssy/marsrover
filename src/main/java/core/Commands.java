package core;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Commands {
    private final List<InstructionHandler> instructionHandlers;

    public Commands(Character... chars) {
        this.instructionHandlers = Arrays.stream(chars)
                .map(InstructionHandler::new)
                .collect(Collectors.toList());
    }

    public List<InstructionHandler.Instruction> execute() {
        return this.instructionHandlers.stream()
                .map(InstructionHandler::transform)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
