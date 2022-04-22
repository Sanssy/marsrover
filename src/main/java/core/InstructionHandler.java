package core;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record InstructionHandler(char instructionHandler) {

    public interface Instruction {
        static List<Instruction> values() {
            return Stream.of(List.of(Rotation.values()), List.of(Move.values()))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
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
