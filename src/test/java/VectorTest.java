import core.Direction;
import core.Vector;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static core.InstructionHandler.Instruction;

public class VectorTest {

    @Test
    public void retrieve_forward_vector_from_a_direction() {
        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.NORTH, Instruction.FORWARD)).isEqualTo(new Vector(0, 1));

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.SOUTH, Instruction.FORWARD)).isEqualTo(new Vector(0, -1));

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.EAST, Instruction.FORWARD)).isEqualTo(new Vector(1, 0));

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.WEST, Instruction.FORWARD)).isEqualTo(new Vector(-1, 0));
    }

    @Test
    public void retrieve_backward_vector_from_a_direction() {
        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.NORTH, Instruction.BACKWARD)).isEqualTo(new Vector(0, -1));

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.SOUTH, Instruction.BACKWARD)).isEqualTo(new Vector(0, 1));

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.EAST, Instruction.BACKWARD)).isEqualTo(new Vector(-1, 0));

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.WEST, Instruction.BACKWARD)).isEqualTo(new Vector(1, 0));
    }
}
