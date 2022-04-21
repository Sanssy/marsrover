import core.Position;
import core.Vector;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    public void should_translate_position_of_1_0() {
        Position initialPosition = new Position(0,2);

        Position expected = initialPosition.translate(Vector.EAST);

        Assertions.assertThat(expected).isEqualTo(new Position(1,2));
    }

}
