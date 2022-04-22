package core;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Instruction {

    static List<Instruction> values() {
        return Stream.of(List.of(Rotation.values()), List.of(Move.values()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    char value();

    static Optional<Instruction> from(Character character) {
        return Instruction.values().stream().filter(instruction -> instruction.value() == character).findAny();
    }

    enum Rotation implements Instruction {
        LEFT('l'), RIGHT('r');

        private final char value;

        Rotation(char value) {
            this.value = value;
        }

        public char value() {
            return this.value;
        }

    }

    enum Move implements Instruction {
        FORWARD('f'), BACKWARD('b');

        private final char value;

        Move(char value) {
            this.value = value;
        }

        public char value() {
            return this.value;
        }
    }
}
