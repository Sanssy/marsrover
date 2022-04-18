package roverTest;

import core.Direction;
import core.Position;
import core.Rover;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    public void should_turn_rover_at_left_and_change_his_direction_facing_north_to_west() {
        Rover rover = initRoverPositionAndDirection(1, 3, Direction.NORTH);

        rover.turnLeft();

        assertThat(rover.currentDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    public void should_turn_rover_at_left_and_change_his_direction_facing_west_to_north() {
        Rover rover = initRoverPositionAndDirection(2, 3, Direction.WEST);

        rover.turnLeft();

        assertThat(rover.currentDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    public void should_turn_rover_at_left_and_change_his_direction_facing_east_to_north() {
        Position initialPosition = new Position(2, 4);
        Rover rover = new Rover(initialPosition, Direction.EAST);

        rover.turnLeft();

        assertThat(rover.currentDirection()).isEqualTo(Direction.SOUTH);
    }

    @Test
    public void should_turn_rover_at_right_and_change_his_direction_facing_south_to_east() {
        Rover rover = initRoverPositionAndDirection(3, 1, Direction.SOUTH);

        rover.turnRight();

        assertThat(rover.currentDirection()).isEqualTo(Direction.EAST);
    }

    private Rover initRoverPositionAndDirection(int x, int y, Direction direction) {
        Position initialPosition = new Position(x, y);

        return new Rover(initialPosition, direction);
    }

}
