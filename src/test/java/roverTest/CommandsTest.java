package roverTest;

import core.Commands;
import core.Direction;
import core.Position;
import core.Rover;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandsTest {

    @Test
    public void should_execute_a_suite_of_instructions() {
        Rover rover= initRoverPositionAndDirection(2,4, Direction.SOUTH);
        Commands commands = new Commands('#','f','#','#','#','#','#', 'f', 'f');

        rover.apply(commands);

        assertThat(rover.currentPosition()).isEqualTo(new Position(2,1));
    }

    @Test
    public void should_execute_a_complex_suite_of_instructions() {
        Rover rover= initRoverPositionAndDirection(3,5, Direction.NORTH);
        Commands square = new Commands('f','f','r','f','f','r','f','f','r','f','f');
        rover.apply(square);

        assertThat(rover.currentPosition()).isEqualTo(new Position(3,5));
    }

    private Rover initRoverPositionAndDirection(int x, int y, Direction direction) {
        Position initialPosition = new Position(x, y);

        return new Rover(initialPosition, direction);
    }
}
