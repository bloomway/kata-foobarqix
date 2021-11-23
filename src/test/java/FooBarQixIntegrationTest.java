import com.kleematik.foobarqix.FooBarQixPrinter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class FooBarQixIntegrationTest {

    @Test
    public void it_should_return_1_2_FooFoo_4_BarBar_when_convert_number_for_given_number_between_1_to_5() {
        final String result = FooBarQixPrinter.printNumberBetweenOneToCount(5);
        final var expectedValue = "1 2 FooFoo 4 BarBar ";
        Assertions.assertThat(result).isEqualTo(expectedValue);
    }

}
