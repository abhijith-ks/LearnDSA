package io.abhijith.challenges.amazon;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

public class AddStrings {

    public void findSolution() {
//        String num1 = "99";
        String num1 = "2859";
//        String num2 = "1";
        String num2 = "293";

        String result = "";
        int carry = 0;
        int sum = 0;
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;

        while(l1 >= 0 && l2 >= 0) {
            int a = num1.charAt(l1) - '0';
            int b = num2.charAt(l2) - '0';
            sum = a + b + carry;
            carry = sum / 10;
            result += "" + (sum % 10);
            l1--;l2--;
        }
        while(l1 >= 0) {
            int a = num1.charAt(l1) - '0';
            int b = 0;
            sum = a + b + carry;
            carry = sum / 10;
            result += "" + (sum % 10);
            l1--;
        }
        while (l2 >= 0) {
            int a = 0;
            int b = num2.charAt(l2) - '0';
            sum = a + b + carry;
            carry = sum / 10;
            result += "" + (sum % 10);
            l2--;
        }
        if(carry > 0) {
            result  = result + "" + carry;
        }
        System.out.println(reverseString(result));
    }

    private String reverseString(String str) {
        int i = 0, j = str.length() - 1;
        char[] charArray = str.toCharArray();
        while(i < j) {
            char swapTemp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = swapTemp;
            i++;j--;
        }
        return String.valueOf(charArray);
    }

}
