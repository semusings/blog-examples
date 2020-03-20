package day27;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
Given a string of round, curly, and square open and closing brackets,
return whether the brackets are balanced (well-formed).

For example, given the string "([])[]({})", you should return true.

Given the string "([)]" or "((()", you should return false.
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
