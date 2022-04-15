import core.Direction;
import core.Orientation;
import core.Orientations;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrientationTest {
    @Test
    public void should_turns_at_left_from_south_till_returning_at_south() {
        Orientation orientation= Orientations.build(Direction.SOUTH);
        Orientation expected = orientation.atLeft();
        Assertions.assertThat(expected).isEqualTo(Orientations.build(Direction.WEST));
        expected = expected.atLeft();
        Assertions.assertThat(expected).isEqualTo(Orientations.build(Direction.NORTH));
        expected = expected.atLeft();
        Assertions.assertThat(expected).isEqualTo(Orientations.build(Direction.EAST));
        expected = expected.atLeft();
        Assertions.assertThat(expected).isEqualTo(Orientations.build(Direction.SOUTH));
    }
}
