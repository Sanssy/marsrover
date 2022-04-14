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
        Position initialPosition = new Position(2,1);
        Direction initialDirection = Direction.SOUTH;

        Rover rover = new Rover(initialPosition, initialDirection);

        String expected = rover.fullLocation();

        assertThat(expected).isEqualTo("2:1:S");
    }

    @Test
    public void should_move_rover_forward_with_starting_point_at_0_2() {
        Position initialPosition = new Position(0,2);
        Direction initialDirection = Direction.NORTH;

        Rover rover = new Rover(initialPosition, initialDirection);

        rover.moveForward();

        assertThat(rover.currentPosition()).isEqualTo(new Position(0, 3));
    }

    @Test
    public void should_move_rover_forward_with_starting_point_at_2_2_facing_south() {
        Position initialPosition = new Position(2,2);
        Direction initialDirection = Direction.SOUTH;

        Rover rover = new Rover(initialPosition, initialDirection);

        rover.moveForward();

        assertThat(rover.currentPosition()).isEqualTo(new Position(2, 1));
    }


    @Test
    public void should_move_rover_forward_with_starting_point_at_0_2_facing_east() {
        Position initialPosition = new Position(0,2);
        Direction initialDirection = Direction.EAST;

        Rover rover = new Rover(initialPosition, initialDirection);

        rover.moveForward();

        assertThat(rover.currentPosition()).isEqualTo(new Position(1, 2));
    }

    @Test
    public void should_move_rover_forward_with_starting_point_at_6_3_facing_west() {
        Position initialPosition = new Position(6,3);
        Direction initialDirection = Direction.WEST;

        Rover rover = new Rover(initialPosition, initialDirection);

        rover.moveForward();

        assertThat(rover.currentPosition()).isEqualTo(new Position(5, 3));
    }

    @Test
    public void should_move_rover_backward_with_starting_point_at_3_3_facing_south() {
        Position initialPosition = new Position(3,3);
        Direction initialDirection = Direction.SOUTH;

        Rover rover = new Rover(initialPosition, initialDirection);

        rover.moveBackward();

        assertThat(rover.currentPosition()).isEqualTo(new Position(3, 4));
    }


}
