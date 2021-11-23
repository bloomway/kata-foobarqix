import com.kleematik.foobarqix.FooBarQix;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class FooBarQixTest {

    private static final String FOO = "Foo";
    private static final String BAR = "Bar";
    private static final String QIX = "Qix";

    private String buildOutput(String value, int count) {
        return value.repeat(count);
    }

    private String concatenate(String value1, String value2) {
        return String.format("%s%s", value1, value2);
    }

    @Test
    public void it_should_return_one_when_convert_number_to_one_if_given_number_equals_one() {
        // given
        int number = 1;
        // when
        String result = FooBarQix.convert(number);
        // then
        String expectedValue = "1";
        assertThat(result).isEqualTo(expectedValue);
    }

    @Test
    public void it_should_return_the_given_number_when_convert_number_if_given_number_is_not_multiple_and_not_containing_3_5_7() {
        // given
        int number = 2;
        // when
        String result = FooBarQix.convert(number);
        // then
        assertThat(result).isEqualTo("2");

        number = 4;
        result = FooBarQix.convert(number);
        // then
        assertThat(result).isEqualTo("4");
    }

    @Test
    public void it_should_return_Foo_when_convert_number_if_given_number_is_multiple_of_3() {
        // when
        String result = FooBarQix.convert(6);
        // then
        assertThat(result).isEqualTo(buildOutput(FOO, 1));
    }

    @Test
    public void it_should_return_Bar_when_convert_number_if_given_number_is_multiple_of_5() {
        // when
        String result = FooBarQix.convert(10);
        // then
        assertThat(result).isEqualTo(buildOutput(BAR, 1));
    }

    @Test
    public void it_should_return_Qix_when_convert_number_if_given_number_contains_7() {
        // when
        String result = FooBarQix.convert(7);
        // then
        assertThat(result).isEqualTo(QIX);
    }

    @Test
    public void it_should_return_FooFoo_when_convert_number_if_given_number_is_3() {
        String result = FooBarQix.convert(3);
        assertThat(result).isEqualTo(buildOutput(FOO, 2));
    }

    @Test
    public void it_should_return_BarBar_when_convert_number_if_given_number_is_5_or_contains_5() {
        String result = FooBarQix.convert(5);
        assertThat(result).isEqualTo(buildOutput(BAR, 2));

        result = FooBarQix.convert(25);
        assertThat(result).isEqualTo(buildOutput(BAR, 2));
    }

    @Test
    public void it_should_return_Foo_when_convert_number_if_given_number_is_13() {
        String result = FooBarQix.convert(13);
        assertThat(result).isEqualTo(buildOutput(FOO, 1));
    }

    @Test
    public void it_should_return_Foo_when_convert_number_if_given_number_is_17() {
        String result = FooBarQix.convert(17);
        assertThat(result).isEqualTo(buildOutput(QIX, 1));
    }

    @Test
    public void it_should_return_FooBarBar_when_convert_number_if_given_number_is_15() {
        String result = FooBarQix.convert(15);
        assertThat(result).isEqualTo(concatenate(FOO, buildOutput(BAR, 2)));
    }

    @Test
    public void it_should_return_FooFooFoo_when_convert_number_if_given_number_is_33() {
        String result = FooBarQix.convert(33);
        assertThat(result).isEqualTo(buildOutput(FOO, 3));
    }

    @Test
    public void it_should_return_BarBarBar_when_convert_number_if_given_number_is_55() {
        String result = FooBarQix.convert(55);
        assertThat(result).isEqualTo(buildOutput(BAR, 3));
    }

    @Test
    public void it_should_return_QixQix_when_convert_number_if_given_number_is_77() {
        String result = FooBarQix.convert(77);
        assertThat(result).isEqualTo(buildOutput(QIX, 2));
    }

    @Test
    public void it_should_return_FooQix_when_convert_number_if_given_number_is_27() {
        String result = FooBarQix.convert(27);
        assertThat(result).isEqualTo(concatenate(FOO, QIX));
    }

    @Test
    public void it_should_return_FooBar_when_convert_number_if_given_number_is_51() {
        String result = FooBarQix.convert(51);
        assertThat(result).isEqualTo(concatenate(FOO, BAR));
    }

    @Test
    public void it_should_return_BarFoo_when_convert_number_if_given_number_is_53() {
        String result = FooBarQix.convert(53);
        assertThat(result).isEqualTo(concatenate(BAR, FOO));
    }
}
