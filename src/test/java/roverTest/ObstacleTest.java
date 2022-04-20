package roverTest;

import core.*;
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

        InstructionHandler.Instruction forward = InstructionHandler.Instruction.FORWARD;

        rover.move(forward);

        assertThat(rover.currentPosition()).isEqualTo(initialPosition);
    }

    @Test
    public void should_stop_when_encountering_obstacle_while_trying_to_move_backward() {
        List<Position> obstacles = new ArrayList<>();
        Position rock = new Position(10, 4);
        obstacles.add(rock);

        Grid grid = new Grid(obstacles);
        Position initialPosition = new Position(9, 4);
        Rover rover = new Rover(initialPosition, Direction.WEST, grid);

        InstructionHandler.Instruction backward = InstructionHandler.Instruction.BACKWARD;

        rover.move(backward);

        assertThat(rover.currentPosition()).isEqualTo(initialPosition);
    }

    @Test
    public void should_make_a_state_report_when_encountered_an_obstacle() {
        List<Position> obstacles = new ArrayList<>();
        Position rock = new Position(0, 4);
        obstacles.add(rock);

        Grid grid = new Grid(obstacles);

        Position initialPosition = new Position(9, 4);
        Rover rover = new Rover(initialPosition, Direction.WEST, grid);

        InstructionHandler.Instruction backward = InstructionHandler.Instruction.BACKWARD;

        rover.move(backward);

        assertThat(rover.state()).isEqualTo(
                "Command execution aborted due to an obstacle. " +
                "My current position is " + rover.currentPosition() +
                " facing " + Direction.WEST + " direction");
    }

}
