package roverTest;

import core.Direction;
import core.Grid;
import core.Position;
import core.Rover;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ObstacleTest {


    @Test
    public void should_stop_when_encountering_obstacle() {
        List<Position> obstacles = new ArrayList<>();
        Position rock = new Position(4, 7);
        obstacles.add(rock);

        Grid grid = new Grid(obstacles);
        Position initialPosition = new Position(3, 7);
        Rover rover = new Rover(initialPosition, Direction.EAST, grid);

        rover.moveForward();

        assertThat(rover.currentPosition()).isEqualTo(initialPosition);
    }

    @Test
    public void should_stop_when_encountering_obstacle_while_trying_to_move_backward() {
        List<Position> obstacles = new ArrayList<>();
        Position rock = new Position(0, 4);
        obstacles.add(rock);

        Grid grid = new Grid(obstacles);
        Position initialPosition = new Position(9, 4);
        Rover rover = new Rover(initialPosition, Direction.WEST, grid);

        rover.moveBackward();

        assertThat(rover.currentPosition()).isEqualTo(initialPosition);
    }

    @Test
    public void should_report_an_obstacle_when_encountered() {
        List<Position> obstacles = new ArrayList<>();
        Position rock = new Position(0, 4);
        obstacles.add(rock);

        Grid grid = new Grid(obstacles);

        Position initialPosition = new Position(9, 4);
        Rover rover = new Rover(initialPosition, Direction.WEST, grid);

        assertThat(rover.state()).isEqualTo("Command execution aborted due to an obstacle, my current position is " + rover.currentPosition());
    }

}
