import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {

    Calculator sut;

    @BeforeEach
    public void initEachTest() {
        sut = new Calculator();
        System.out.println("Калькулятор создан");
    }
    @BeforeEach
    public void afterEachTest() {
        sut = null;
        System.out.println("Калькулятор обнулен");
    }

    @Test
    public void testDivide() {
        int a = 4, b = 2, expected = 2;

        int result = sut.divide.apply(a, b);

        assertEquals(expected, result);
    }

    @Test
    public void testDivideToZero() {
        int a = 2, b = 0;

        assertThrowsExactly(ArithmeticException.class, () -> sut.divide.apply(a, b));
    }

    @Test
    public void testDivideWorking() {
        int a = 10, b = 0, expected = 0;

        int result = sut.divideWorking.apply(a, b);

        assertEquals(expected, result);
    }
    @MethodSource("source")
    @ParameterizedTest
    public void testDivideWorkingParam(int a, int b, int expected) {
        int result = sut.divideWorking.apply(a, b);

        assertEquals(expected, result);
    }

    public static Stream<Arguments> source() {
        return Stream.of(Arguments.of(5, 2, 2),
                                Arguments.of(10, -2, -5),
                                Arguments.of(-1, 0, 0));
    }
}