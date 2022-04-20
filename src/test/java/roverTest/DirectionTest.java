package roverTest;

import core.Direction;
import core.Instruction;
import core.Position;
import core.Rover;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    private static Instruction left;
    private static Instruction right;

    @BeforeAll
    static void init_forward_instruction() {
        left = new Instruction('l');
        right = new Instruction('r');
    }

    @Test
    public void should_turn_rover_at_left_and_change_his_direction_facing_north_to_west() {
        Rover rover = initRoverPositionAndDirection(1, 3, Direction.NORTH);

        rover.turn(left);

        assertThat(rover.currentDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    public void should_turn_rover_at_left_and_change_his_direction_facing_west_to_north() {
        Rover rover = initRoverPositionAndDirection(2, 3, Direction.WEST);

        rover.turn(left);

        assertThat(rover.currentDirection()).isEqualTo(Direction.SOUTH);
    }

    @Test
    public void should_turn_rover_at_left_and_change_his_direction_facing_east_to_north() {
        Position initialPosition = new Position(2, 4);
        Rover rover = new Rover(initialPosition, Direction.EAST);

        rover.turn(left);

        assertThat(rover.currentDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    public void should_turn_rover_at_right_and_change_his_direction_facing_south_to_east() {
        Rover rover = initRoverPositionAndDirection(3, 1, Direction.SOUTH);

        rover.turn(right);

        assertThat(rover.currentDirection()).isEqualTo(Direction.WEST);
    }

    private Rover initRoverPositionAndDirection(int x, int y, Direction direction) {
        Position initialPosition = new Position(x, y);

        return new Rover(initialPosition, direction);
    }

}
