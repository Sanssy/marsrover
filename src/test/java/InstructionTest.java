import core.Instruction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InstructionTest {

    @Test
    public void should_do_nothing_when_unknown_instruction() {

        Instruction instruction = new Instruction('e');

        Assertions.assertThat(instruction.verify()).isFalse();

    }

}
