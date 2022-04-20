package core;

import java.util.Arrays;
import java.util.Optional;

public record InstructionHandler(char instruction) {

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

    public char value() {
        return this.instruction;
    }

    public Optional<Instruction> transform() {
        return Arrays.stream(Instruction.values()).filter(instruction -> instruction.value == this.instruction).findAny();
    }
}
