package core;

import java.util.Arrays;

public record Instruction(char instruction) {

    public enum ValidInstruction {
        LEFT('l'),
        RIGHT('r'),
        FORWARD('f'),
        BACKWARD('b');

        char value;

        ValidInstruction(char value) {
            this.value = value;
        }
    }

    public char value() {
        return this.instruction;
    }

    public boolean verify() {
        return Arrays.stream(ValidInstruction.values()).anyMatch(instruction -> instruction.value == this.instruction);
    }
}
