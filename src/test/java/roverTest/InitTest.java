package roverTest;

import core.Direction;
import core.Position;
import core.Rover;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InitTest {

    @Test
    public void should_render_rover_initial_position() {
        Position initialPosition = new Position(1,1);

        Rover rover = new Rover(initialPosition, Direction.NORTH);

        Position expected = rover.currentPosition();

        assertThat(expected).isEqualTo(initialPosition);
    }

    @Test
    public void should_render_rover_initial_direction() {
        Position initialPosition = new Position(1,1);
        Direction initialDirection = Direction.NORTH;

        Rover rover = new Rover(initialPosition, initialDirection);

        Direction expected = rover.currentDirection();

        assertThat(expected).isEqualTo(initialDirection);
    }
}
