package core;

import java.util.Arrays;
import java.util.stream.Stream;

public record Instruction(char instruction) {

    private enum validInstruction {
        LEFT('l'),
        RIGHT('r'),
        FORWARD('f'),
        BACKWARD('b');

        char value;

        validInstruction(char value) {
            this.value = value;
        }
    }

    public char compute() {
        return this.instruction;
    }

    public boolean verify() {
        return Arrays.stream(validInstruction.values()).anyMatch(validInstruction -> validInstruction.value == this.instruction);
    }
}
