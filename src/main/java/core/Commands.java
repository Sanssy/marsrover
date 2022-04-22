package core;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Commands {
    private final Character[] chars;

    public Commands(Character... chars) {
        this.chars = chars;
    }

    public List<Instruction> validInstructions() {
        return Arrays.stream(this.chars)
                .map(Instruction::from)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
