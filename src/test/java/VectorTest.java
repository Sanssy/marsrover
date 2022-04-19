import core.Direction;
import core.Vector;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class VectorTest {

    @Test
    public void retrieve_forward_vector_from_a_direction() {
        Assertions.assertThat(Vector.retrieveForwardTranslationFrom(Direction.EAST)).isEqualTo(new Vector(0, 1));

        Assertions.assertThat(Vector.retrieveForwardTranslationFrom(Direction.WEST)).isEqualTo(new Vector(0, -1));

        Assertions.assertThat(Vector.retrieveForwardTranslationFrom(Direction.NORTH)).isEqualTo(new Vector(1, 0));

        Assertions.assertThat(Vector.retrieveForwardTranslationFrom(Direction.SOUTH)).isEqualTo(new Vector(-1, 0));
    }

    @Test
    public void retrieve_backward_vector_from_a_direction() {
        Assertions.assertThat(Vector.retrieveBackwardTranslationFrom(Direction.NORTH)).isEqualTo(new Vector(0, -1));

        Assertions.assertThat(Vector.retrieveBackwardTranslationFrom(Direction.SOUTH)).isEqualTo(new Vector(0, 1));

        Assertions.assertThat(Vector.retrieveBackwardTranslationFrom(Direction.EAST)).isEqualTo(new Vector(-1, 0));

        Assertions.assertThat(Vector.retrieveBackwardTranslationFrom(Direction.WEST)).isEqualTo(new Vector(1, 0));
    }
}
