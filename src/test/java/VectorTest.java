import core.Direction;
import core.Vector;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class VectorTest {

    @Test
    public void retrieve_forward_vector_from_a_direction() {
        Vector vector = new Vector(1,2);

        Assertions.assertThat(vector.retrieveForwardTranslationFrom(Direction.EAST)).isEqualTo(new Vector(0, 1));

        Assertions.assertThat(vector.retrieveForwardTranslationFrom(Direction.WEST)).isEqualTo(new Vector(0, -1));

        Assertions.assertThat(vector.retrieveForwardTranslationFrom(Direction.NORTH)).isEqualTo(new Vector(1, 0));

        Assertions.assertThat(vector.retrieveForwardTranslationFrom(Direction.SOUTH)).isEqualTo(new Vector(-1, 0));
    }
}
