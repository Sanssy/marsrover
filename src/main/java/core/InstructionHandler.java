package core;

import java.util.List;
import java.util.Optional;

public record InstructionHandler(char instructionHandler) {

    public interface Instruction {
        static List<Instruction> values() {
            return List.of(Rotation.LEFT, Rotation.RIGHT, Move.FORWARD, Move.BACKWARD);
        }
        char value();
    }

    public enum Rotation implements Instruction {
        LEFT('l'), RIGHT('r');

        private final char value;

        Rotation(char value) {
            this.value = value;
        }

        public char value() {
            return this.value;
        }
    }

    public enum Move implements Instruction {
        FORWARD('f'), BACKWARD('b');

        private final char value;

        Move(char value) {
            this.value = value;
        }

        public char value() {
            return this.value;
        }
    }

    public Optional<Instruction> transform() {
        return Instruction.values().stream().filter(instruction -> instruction.value() == this.instructionHandler).findAny();
    }
}
