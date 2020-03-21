package day44;

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
                        {new int[]{1, 5, 8, 9, 10}, 0},
                        {new int[]{2, 4, 1, 3, 5}, 3},
                        {new int[]{5, 4, 3, 2, 1}, 10},
                }
        );
    }

    /*
        5, 4, 3, 2, 1

        5
     */

    @BeforeEach
    void setUp() {
        this.solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("data")
    void testSolution(int[] input, int expected) {
        int actual = this.solution.countNoOfInversions(input);
        assertEquals(expected, actual);
    }

}