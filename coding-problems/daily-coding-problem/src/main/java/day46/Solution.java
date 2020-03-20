package day46;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
This problem was asked by Amazon.

Given a string, find the longest palindromic contiguous substring.
If there are more than one with the maximum length, return any one.

For example, the longest palindromic substring of aabcdcb is bcdcb.
The longest palindromic substring of bananas is anana.
*/
class Solution {

    private static final Map<Character, Character> pairs = new HashMap<Character, Character>() {
        {
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }
    };

    boolean hasBalanceBrackets(String input) {

        if (input == null)
            throw new IllegalArgumentException("input string is null.");

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);

            if (pairs.containsValue(c)) {
                stack.push(c);
            }

            if (pairs.containsKey(c)) {

                if (stack.isEmpty()) {
                    return false;
                }

                Character pop = stack.pop();

                if (!pop.equals(pairs.get(c))) {
                    return false;
                }

            }

        }

        return stack.isEmpty();
    }
}
