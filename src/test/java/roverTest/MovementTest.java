package roverTest;

import core.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovementTest {

    private static Instruction forward;

    @BeforeAll
    static void init_forward_instruction() {
        forward = new Instruction('f');
    }

    @Test
    public void should_move_rover_forward_with_starting_point_at_0_2() {
        Rover rover = initRoverPositionAndDirection(0, 2, Direction.NORTH);

        rover.move(forward);

        assertThat(rover.currentPosition()).isEqualTo(new Position(0, 3));
    }

    @Test
    public void should_move_rover_forward_with_starting_point_at_2_2_facing_south() {
        Rover rover = initRoverPositionAndDirection(2, 2, Direction.SOUTH);

        rover.move(forward);

        assertThat(rover.currentPosition()).isEqualTo(new Position(2, 1));
    }

    @Test
    public void should_move_rover_forward_with_starting_point_at_0_2_facing_east() {
        Rover rover = initRoverPositionAndDirection(0, 2, Direction.EAST);

        rover.move(forward);

        assertThat(rover.currentPosition()).isEqualTo(new Position(1, 2));
    }

    @Test
    public void should_move_rover_forward_with_starting_point_at_6_3_facing_west() {
        Rover rover = initRoverPositionAndDirection(6, 3, Direction.WEST);

        rover.move(forward);

        assertThat(rover.currentPosition()).isEqualTo(new Position(5, 3));
    }

    @Test
    public void should_move_rover_backward_with_starting_point_at_3_3_facing_south() {
        Rover rover = initRoverPositionAndDirection(3, 3, Direction.SOUTH);

        Instruction backward = new Instruction('b');

        rover.move(backward);

        assertThat(rover.currentPosition()).isEqualTo(new Position(3, 4));
    }

    @Test
    public void should_move_forward_from_the_west_position() {
        Grid grid = new Grid(8,8);
        Position initialPosition = new Position(8,5);

        Rover rover = new Rover(initialPosition, Direction.WEST, grid);

        rover.move(forward);

        assertThat(rover.currentPosition()).isEqualTo(new Position(7, 5));
    }

    private Rover initRoverPositionAndDirection(int x, int y, Direction direction) {
        Position initialPosition = new Position(x, y);

        return new Rover(initialPosition, direction);
    }


}
