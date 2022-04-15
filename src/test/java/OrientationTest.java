import core.Direction;
import core.Orientation;
import core.Orientations;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrientationTest {
    @Test
    public void should_turns_at_left_from_south_till_returning_at_south() {
        Orientation orientation= Orientations.build(Direction.SOUTH);
        Orientation actual = orientation.atLeft();
        Assertions.assertThat(actual).isEqualTo(Orientations.build(Direction.WEST));
        actual = actual.atLeft();
        Assertions.assertThat(actual).isEqualTo(Orientations.build(Direction.NORTH));
        actual = actual.atLeft();
        Assertions.assertThat(actual).isEqualTo(Orientations.build(Direction.EAST));
        actual = actual.atLeft();
        Assertions.assertThat(actual).isEqualTo(Orientations.build(Direction.SOUTH));
    }

    @Test
    public void should_turns_at_right_from_north_till_returning_at_north() {
        Orientation orientation= Orientations.build(Direction.NORTH);
        Orientation actual = orientation.atRight();
        Assertions.assertThat(actual).isEqualTo(Orientations.build(Direction.WEST));
        actual = actual.atRight();
        Assertions.assertThat(actual).isEqualTo(Orientations.build(Direction.SOUTH));
        actual = actual.atRight();
        Assertions.assertThat(actual).isEqualTo(Orientations.build(Direction.EAST));
        actual = actual.atRight();
        Assertions.assertThat(actual).isEqualTo(Orientations.build(Direction.NORTH));
    }
}
