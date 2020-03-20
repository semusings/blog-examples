package day46;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    private Solution solution;

    static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {"aabcdcb", "bcdcb"},
                        {"bananas", "anana"},
                }
        );
    }

    @BeforeEach
    void setUp() {
        this.solution = new Solution();
    }


    @ParameterizedTest
    @MethodSource("data")
    void testSolution(String input, boolean expected) {
        boolean actual = this.solution.hasBalanceBrackets(input);

        assertEquals(expected, actual);

    }

}