import core.Direction;
import core.Instruction;
import core.Vector;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class VectorTest {

    private static Instruction forward;
    private static Instruction backward;

    @BeforeAll
    static void init_forward_instruction() {
        forward = new Instruction('f');
        backward = new Instruction('b');
    }

    @Test
    public void retrieve_forward_vector_from_a_direction() {
        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.NORTH, forward)).isEqualTo(new Vector(0, 1));

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.SOUTH, forward)).isEqualTo(new Vector(0, -1));

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.EAST, forward)).isEqualTo(new Vector(1, 0));

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.WEST, forward)).isEqualTo(new Vector(-1, 0));
    }

    @Test
    public void retrieve_backward_vector_from_a_direction() {
        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.NORTH, backward)).isEqualTo(new Vector(0, -1));

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.SOUTH, backward)).isEqualTo(new Vector(0, 1));

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.EAST, backward)).isEqualTo(new Vector(-1, 0));

        Assertions.assertThat(Vector.retrieveTranslationFor(Direction.WEST, backward)).isEqualTo(new Vector(1, 0));
    }
}
