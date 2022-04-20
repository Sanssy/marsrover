package roverTest;

import core.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EdgeTest {

    private static Instruction forward;

    @BeforeAll
    static void init_forward_instruction() {
        forward = new Instruction('f');
    }

    @Test
    public void should_reach_the_south_edge_from_the_north_edge_position() {
        Grid grid = new Grid(5,5);
        Position initialPosition = new Position(3,5);

        Rover rover = new Rover(initialPosition, Direction.NORTH, grid);

        rover.move(forward);

        assertThat(rover.currentPosition()).isEqualTo(new Position(3, 0));
    }

    @Test
    public void should_reach_the_north_edge_from_the_south_edge_position() {
        Grid grid = new Grid(7,7);
        Position initialPosition = new Position(3,0);

        Rover rover = new Rover(initialPosition, Direction.SOUTH, grid);

        rover.move(forward);

        assertThat(rover.currentPosition()).isEqualTo(new Position(3, 7));
    }

    @Test
    public void should_reach_the_east_edge_from_the_west_edge_position() {
        Grid grid = new Grid(7,7);
        Position initialPosition = new Position(0,1);

        Rover rover = new Rover(initialPosition, Direction.WEST, grid);

        rover.move(forward);

        assertThat(rover.currentPosition()).isEqualTo(new Position(7, 1));
    }

    @Test
    public void should_reach_the_west_edge_from_the_east_edge_position() {
        Grid grid = new Grid(8,8);
        Position initialPosition = new Position(8,5);

        Rover rover = new Rover(initialPosition, Direction.EAST, grid);

        rover.move(forward);

        assertThat(rover.currentPosition()).isEqualTo(new Position(0, 5));
    }
}

