package day26;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;


class SolutionTest {

    private Solution solution;

    static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {new int[]{5, 7, 8, 9, 2}},
                }
        );
    }

    @BeforeEach
    void setUp() {
        this.solution = new Solution();
    }


    @ParameterizedTest
    @MethodSource("data")
    void testSolution(int[] input) {
        SinglyLinkedList list = new SinglyLinkedList();
        this.solution.onePassRemove(list, 2);
    }

}