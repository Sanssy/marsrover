import core.Direction;
import core.Vector;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static core.InstructionHandler.Move.BACKWARD;
import static core.InstructionHandler.Move.FORWARD;

public class VectorTest {

    @Test
    public void retrieve_forward_vector_from_a_direction() {
        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.NORTH, FORWARD)).isEqualTo(Vector.NORTH);

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.SOUTH, FORWARD)).isEqualTo(Vector.SOUTH);

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.EAST, FORWARD)).isEqualTo(Vector.EAST);

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.WEST, FORWARD)).isEqualTo(Vector.WEST);
    }

    @Test
    public void retrieve_backward_vector_from_a_direction() {
        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.NORTH, BACKWARD)).isEqualTo(Vector.SOUTH);

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.SOUTH, BACKWARD)).isEqualTo(Vector.NORTH);

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.EAST, BACKWARD)).isEqualTo(Vector.WEST);

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.WEST, BACKWARD)).isEqualTo(Vector.EAST);
    }
}
