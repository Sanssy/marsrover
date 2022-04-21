package core;

import java.util.Arrays;
import java.util.Optional;

public record InstructionHandler(char instructionHandler) {

    public enum Instruction {
        LEFT('l'),
        RIGHT('r'),
        FORWARD('f'),
        BACKWARD('b');

        char value;

        Instruction(char value) {
            this.value = value;
        }
    }

    public Optional<Instruction> transform() {
        return Arrays.stream(Instruction.values()).filter(instruction -> instruction.value == this.instructionHandler).findAny();
    }
}
