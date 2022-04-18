package roverTest;

import core.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandsTest {

    private static Instruction f,r,l,b;
    private static Commands commands;

    @BeforeAll
    static void initCommands() {
        commands = new Commands();
        f = new Instruction('f'); // forward
        r = new Instruction('r'); // right
        l = new Instruction('l'); // left
        b = new Instruction('b'); // backward
    }

    @Test
    public void should_execute_a_suite_of_instructions() {
        Rover rover= initRoverPositionAndDirection(2,4, Direction.SOUTH);
        commands.generate(f,f,b,f,l);
        rover.apply(commands);

        assertThat(rover.currentPosition()).isEqualTo(new Position(2,2));
    }

    @Test
    public void should_execute_a_complex_suite_of_instructions() {
        Rover rover= initRoverPositionAndDirection(3,5, Direction.NORTH);

        commands.generate(f,f,r,f,f,r,f,f,r,f,f); // square
        rover.apply(commands);

        assertThat(rover.currentPosition()).isEqualTo(new Position(3,5));
    }

    private Rover initRoverPositionAndDirection(int x, int y, Direction direction) {
        Position initialPosition = new Position(x, y);

        return new Rover(initialPosition, direction);
    }
}
