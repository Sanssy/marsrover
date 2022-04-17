import core.Instruction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InstructionTest {

    @Test
    public void should_return_false_when_receiving_unknown_instruction() {

        Instruction instruction = new Instruction('e');

        Assertions.assertThat(instruction.verify()).isFalse();

    }

    @Test
    public void should_recognize_known_instruction() {

        Instruction instruction = new Instruction('f');

        Assertions.assertThat(instruction.verify()).isTrue();

    }

}
