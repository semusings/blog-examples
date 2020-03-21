import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortTest {

    private MergeSort solution;

    static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {new int[]{5, 7, 8, 9, 2}, new int[]{2, 5, 7, 8, 9}},
                }
        );
    }

    @BeforeEach
    void setUp() {
        this.solution = new MergeSort();
    }


    @ParameterizedTest
    @MethodSource("data")
    void testSolution(int[] input, int[] expected) {
        this.solution.mergeSort(input);
        assertArrayEquals(expected, input);
    }

}