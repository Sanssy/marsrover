import core.*;
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
    public void should_turn_rover_at_left_and_change_his_orientation_facing_north_to_west() {
        Rover rover = initRoverPositionAndDirection(3, 3, Direction.NORTH);

        rover.turnLeft();

        assertThat(rover.currentOrientation()).isEqualTo(Orientations.build(Direction.EAST));
    }

    @Test
    public void should_turn_rover_at_left_and_change_his_orientation_facing_west_to_north() {
        Rover rover = initRoverPositionAndDirection(3, 3, Direction.WEST);

        rover.turnLeft();

        assertThat(rover.currentOrientation()).isEqualTo(Orientations.build(Direction.NORTH));
    }

    @Test
    public void should_turn_rover_at_left_and_change_his_orientation_facing_east_to_north() {
        Position initialPosition = new Position(2, 4);
        Rover rover = new Rover(initialPosition, Direction.EAST);

        rover.turnLeft();

        assertThat(rover.currentOrientation()).isEqualTo(Orientations.build(Direction.SOUTH));
    }

    @Test
    public void should_turn_rover_at_right_and_change_his_orientation_facing_south_to_east() {
        Rover rover = initRoverPositionAndDirection(3, 3, Direction.SOUTH);

        rover.turnRight();

        assertThat(rover.currentOrientation()).isEqualTo(Orientations.build(Direction.EAST));
    }

    @Test
    public void should_reach_the_south_edge_from_the_north_edge_position() {
        Grid grid = new Grid(5,5);
        Position initialPosition = new Position(3,5);

        Rover rover = new Rover(initialPosition, Direction.NORTH, grid);

        rover.move();

        assertThat(rover.currentPosition()).isEqualTo(new Position(3, 1));
    }

    @Test
    public void should_reach_the_north_edge_from_the_south_edge_position() {
        Grid grid = new Grid(7,7);
        Position initialPosition = new Position(3,1);

        Rover rover = new Rover(initialPosition, Direction.SOUTH, grid);

        rover.move();

        assertThat(rover.currentPosition()).isEqualTo(new Position(3, 7));
    }

    @Test
    public void should_reach_the_east_edge_from_the_west_edge_position() {
        Grid grid = new Grid(7,7);
        Position initialPosition = new Position(1,1);

        Rover rover = new Rover(initialPosition, Direction.WEST, grid);

        rover.move();

        assertThat(rover.currentPosition()).isEqualTo(new Position(7, 1));
    }

    @Test
    public void should_reach_the_west_edge_from_the_east_edge_position() {
        Grid grid = new Grid(8,8);
        Position initialPosition = new Position(8,5);

        Rover rover = new Rover(initialPosition, Direction.EAST, grid);

        rover.move();

        assertThat(rover.currentPosition()).isEqualTo(new Position(1, 5));
    }

    private Rover initRoverPositionAndDirection(int x, int y, Direction direction) {
        Position initialPosition = new Position(x, y);

        return new Rover(initialPosition, direction);
    }


}
