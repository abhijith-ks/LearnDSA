package io.abhijith.challenges.graph;

import java.util.*;

/**
 * Given a string of paranthesis, alphabets, digits etc.
 * Remove minimum number of brackets to make it a balanced sequence
 * Example
 * Input: (a)())()
 * Output: [(a)()(), (a())()]
 */

public class BalancedBracketWithGraph {

    String input = "(a)())()";
    Set<String> output = new HashSet<>();

    public void findSolution() {

        Queue<String> queue = new LinkedList<>();
        queue.add(input);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            boolean found = false;
            for (int i = 0; i < queueSize; i++) {
                String expression = queue.remove();
                if(validateBrackets(expression)) {
                    output.add(expression);
                    found = true;
                }
                if(!found) {
                    for (int j = 0; j < expression.length(); j++) {
                        if (expression.charAt(j) == '(' || expression.charAt(j) == ')') {
                            if (j + 1 == expression.length()) {
                                queue.add(expression.substring(0, expression.length() - 1));
                            } else {
                                queue.add(expression.substring(0, j) + "" + expression.substring(j + 1, expression.length()));
                            }
                        }
                    }
                }
            }
            if(found) {
                break;
            }
        }

        for (String printValue : output) {
            System.out.println(printValue);
        }

    }

    public boolean validateBrackets(String expression) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == '(' || expression.charAt(i) == ')') {
                if(expression.charAt(i) == '(') {
                    stack.push('(');
                } else {
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(')');
                    }
                }
            }
        }

        return stack.isEmpty();
    }


}
