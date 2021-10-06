package io.abhijith.challenges.string;

/**
 * Given a string s, find the longest palindromic substring in s.
 * Dynamic Programming
 *
 * @author abhijith-ks
 */

public class LongestPalindromeSubstring {

    public void findSolution(String s) {
//		s = "aaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaa";

        s = "bac";
        int n = s.length();
        // table[i][j] will be false if substring str[i..j] is not palindrome else true
        boolean[][] table = new boolean[n][n];

        int maxLength = 1, start = 0;

        // All substring of length 1 are palindrome
        for (int i = 0; i < n; i++)
            table[i][i] = true;

        // Check for substring of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for lengths greater than 2. k is length of substring
        for (int k = 3; k <= n; k++) {
            //Fix the starting index
            for (int i = 0; i < n - k + 1; i++) {
                // Get the ending index of substring from starting index i and length k
                int j = i + k - 1;

                // Check for substring from i-th index to j-th index iff str[i+1] to str[j-1] is a palindrome
                if (table[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    table[i][j] = true;
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }

            }
        }

        System.out.println(s.substring(start, start + maxLength));

    }

}


// Different solution
//String sr = "";
//for(int i=s.length()-1; i>=0; i--) {
//	sr += s.charAt(i);
//}
//String copyString = "";
//String str = "";
//for(int i=0; i<s.length(); i++) {
//	for(int j=i+1; j<=s.length(); j++) {
//		if((sr.indexOf(s.substring(i, j))) != -1){
//			if(sr.indexOf(s.substring(i,j)) != s.length()-j) {
//				continue;
//			}
//			if(copyString.length() < s.substring(i,j).length()) {
//				copyString = s.substring(i,j);
//			}
//		}
//	}
//}
//
//System.out.println(copyString);
