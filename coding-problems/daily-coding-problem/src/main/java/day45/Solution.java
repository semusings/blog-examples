package day45;

import java.util.Random;

/*
This problem was asked by Two Sigma.

Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability,
implement a function rand7() that returns an integer from 1 to 7 (inclusive).

Do NOT use system's Math.random()
*/

/*

    This solution is based upon Rejection Sampling.

    The main idea is when you generate a number in the desired range, output
    that number immediately. If the number is out of the desired range, reject it and
    re-sample again. As each number in the desired range has the same
    probability of being chosen, a uniform distribution is produced.

    Obviously, we have to run rand5() function at least twice,
    as there are not enough numbers in the range of 1 to 7.
    By running rand5() twice, we can get integers from 1 to 25 uniformly.

    Since 25 is not a multiple of 7, we have to use rejection sampling.
    Our desired range is integers from 1 to 21, which we can return the answer immediately.
    If not (the integer falls between 22 to 25), we reject it and repeat the whole process again.
*/

class Solution {

    /**
     * @return random integer 1 to 5 (inclusive) with uniform (or equal) probability
     */
    private int rand5() {
        int min = 1;
        int max = 5;
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    int rand7() {
        int row, col, idx;
        do {
            row = rand5();
            col = rand5();
            idx = col + (row - 1) * 5;
        } while (idx > 21);
        return 1 + (idx - 1) % 7;
    }

}