package day45;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        this.solution = new Solution();
    }

    @Test
    void testSolution() {
        IntStream.range(0, 1000)
                .mapToObj(value -> this.solution.rand7())
                .forEach(random -> {
                    assertTrue(
                            random > 0 && random <= 7,
                            String.format("random number: %d -> is not in range {1, 7} inclusive", random)
                    );
                });
    }
}