import core.Direction;
import core.Vector;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static core.InstructionHandler.Instruction;

public class VectorTest {

    @Test
    public void retrieve_forward_vector_from_a_direction() {
        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.NORTH, Instruction.FORWARD)).isEqualTo(Vector.NORTH);

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.SOUTH, Instruction.FORWARD)).isEqualTo(Vector.SOUTH);

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.EAST, Instruction.FORWARD)).isEqualTo(Vector.EAST);

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.WEST, Instruction.FORWARD)).isEqualTo(Vector.WEST);
    }

    @Test
    public void retrieve_backward_vector_from_a_direction() {
        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.NORTH, Instruction.BACKWARD)).isEqualTo(Vector.SOUTH);

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.SOUTH, Instruction.BACKWARD)).isEqualTo(Vector.NORTH);

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.EAST, Instruction.BACKWARD)).isEqualTo(Vector.WEST);

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.WEST, Instruction.BACKWARD)).isEqualTo(Vector.EAST);
    }
}
