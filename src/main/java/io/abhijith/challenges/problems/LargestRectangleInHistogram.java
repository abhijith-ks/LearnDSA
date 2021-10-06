package io.abhijith.challenges.problems;

import java.util.Stack;

/**
 * Find largest rectangle in a histogram
 */

public class LargestRectangleInHistogram {

    public void findSolution() {
//        int[] input = {4, 4, 4, 4}; // 16
//        int[] input = {5, 1, 4, 4, 5}; // 12
//        int[] input = {1, 5, 3, 5, 6}; // 12
//        int[] input = {4, 3, 1, 5, 0, 5}; // 6
        int[] input = {2, 1, 5, 6, 2, 3}; // 10
        int widthUnit = 1;
        int total;
        int maxWidth = Integer.MIN_VALUE;

        if(input.length == 0 || input == null) {
            System.out.println(0);
        }

        for (int i = 0; i < input.length; i++) {
            int current = i;
            total = 1;
            int currentHeight = input[current];
            maxWidth = Math.max(maxWidth, currentHeight * widthUnit);
            int j = i - 1;
            while (j >= 0 && input[j] >= input[current]) {
                total++;
                j--;
            }
            j = i + 1;
            while (j < input.length && input[j] >= input[current]) {
                total++;
                j++;
            }
            maxWidth = Math.max(maxWidth, total * widthUnit * currentHeight);
        }
        System.out.println(maxWidth);
        optimalSolution(input);
    }

    public void optimalSolution(int[] input) {
        if(input.length == 0 || input == null)
            return;

        Stack<Integer> stack = new Stack<>();
        int[] left = new int[input.length];
        int[] right = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            if(stack.isEmpty()) {
                left[i] = 0;
                stack.push(i);
            } else {
                while (!stack.isEmpty() && input[stack.peek()] >= input[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    left[i] = 0;
                } else {
                    left[i] = stack.peek() + 1;
                }
                stack.push(i);
            }
        }
        
        stack.removeAllElements();
        
        for(int i = input.length - 1; i >= 0; i--) {
            if(stack.isEmpty()) {
                right[i] = input.length - 1;
                stack.push(i);
            } else {
                while(!stack.isEmpty() && input[stack.peek()] >= input[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    right[i] = input.length - 1;
                } else {
                    right[i] = stack.peek() - 1;
                }
                stack.push(i);
            }
        }

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            maxArea = Math.max(maxArea, input[i]*(right[i] - left[i] + 1));
        }

        System.out.println(maxArea);
    }

}
