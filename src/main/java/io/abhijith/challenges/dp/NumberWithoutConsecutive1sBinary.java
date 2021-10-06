package io.abhijith.challenges.dp;

/**
 * Given a number n,
 * find total number of numbers from 0 to 2^n-1 which do not have consecutive 1s in their binary representation.
 *
 * https://www.youtube.com/watch?v=a9-NtLIs1Kk&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=39
 */

public class NumberWithoutConsecutive1sBinary {

    public void findSolution() {

        int n = 4;
        int[] a = new int[n];
        int[] b = new int[n];

        a[0] = 1;
        b[0] = 1;

        for(int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }
        System.out.println(a[n - 1] + b[n - 1]);
    }

}
