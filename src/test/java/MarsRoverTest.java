import core.Direction;
import core.Position;
import core.Rover;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MarsRoverTest {

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

    @Test
    public void should_inform_about_rover_full_location() {
        Rover rover = initRoverPositionAndDirection(2, 1, Direction.SOUTH);

        String expected = rover.fullLocation();

        assertThat(expected).isEqualTo("2:1:S");
    }

    @Test
    public void should_move_rover_forward_with_starting_point_at_0_2() {
        Rover rover = initRoverPositionAndDirection(0, 2, Direction.NORTH);

        rover.moveForward();

        assertThat(rover.currentPosition()).isEqualTo(new Position(0, 3));
    }

    @Test
    public void should_move_rover_forward_with_starting_point_at_2_2_facing_south() {
        Rover rover = initRoverPositionAndDirection(2, 2, Direction.SOUTH);

        rover.moveForward();

        assertThat(rover.currentPosition()).isEqualTo(new Position(2, 1));
    }


    @Test
    public void should_move_rover_forward_with_starting_point_at_0_2_facing_east() {
        Rover rover = initRoverPositionAndDirection(0, 2, Direction.EAST);

        rover.moveForward();

        assertThat(rover.currentPosition()).isEqualTo(new Position(1, 2));
    }

    @Test
    public void should_move_rover_forward_with_starting_point_at_6_3_facing_west() {
        Rover rover = initRoverPositionAndDirection(6, 3, Direction.WEST);

        rover.moveForward();

        assertThat(rover.currentPosition()).isEqualTo(new Position(5, 3));
    }

    @Test
    public void should_move_rover_backward_with_starting_point_at_3_3_facing_south() {
        Rover rover = initRoverPositionAndDirection(3, 3, Direction.SOUTH);

        rover.moveBackward();

        assertThat(rover.currentPosition()).isEqualTo(new Position(3, 4));
    }

    @Test
    public void should_turn_rover_at_left_and_change_his_initial_direction_facing_north_to_west() {
        Rover rover = initRoverPositionAndDirection(3, 3, Direction.NORTH);

        rover.turnLeft();

        assertThat(rover.currentDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    public void should_turn_rover_at_left_and_change_his_initial_direction_facing_west_to_south() {
        Rover rover = initRoverPositionAndDirection(3, 3, Direction.WEST);

        rover.turnLeft();

        assertThat(rover.currentDirection()).isEqualTo(Direction.SOUTH);
    }

    @Test
    public void should_turn_rover_at_left_and_change_his_initial_direction_facing_south_to_east() {
        Rover rover = initRoverPositionAndDirection(3, 3, Direction.SOUTH);

        rover.turnLeft();

        assertThat(rover.currentDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    public void should_turn_rover_at_left_and_change_his_initial_direction_facing_east_to_north() {
        Rover rover = initRoverPositionAndDirection(3, 3, Direction.EAST);

        rover.turnLeft();

        assertThat(rover.currentDirection()).isEqualTo(Direction.NORTH);
    }

    private Rover initRoverPositionAndDirection(int x, int y, Direction direction) {
        Position initialPosition = new Position(x, y);

        return new Rover(initialPosition, direction);
    }


}
