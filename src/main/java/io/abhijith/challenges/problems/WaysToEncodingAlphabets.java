package io.abhijith.challenges.problems;

/**
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 * You can assume that the messages are decodable. For example, '001' is not allowed.
 * 
 * @author abhijith-ks
 *
 */

public class WaysToEncodingAlphabets {

	public void findSolution() {
		String data = "1212";
		System.out.println(helper(data, data.length()));
	}
	
	public int helper(String data, int k) {
		if(k == 0)
			return 1;
		
		int s = data.length() - k;
		if(data.charAt(s) == '0')
			return 0;
		
		int result;
		result = helper(data, k-1);
		if(k >= 2 && (Integer.parseInt( "" + data.charAt(s) + "" + data.charAt(s+1)) < 27))
			result += helper(data, k-2);
		return result;
	}
	
}
