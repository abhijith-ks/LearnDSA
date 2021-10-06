package io.abhijith.challenges.string;

public class StringCompression {

    public void findSolution() {
//        String s = "aabbccc";
//        String s = "a";
        String s = "abbbbbbbbbbbb";
        char[] array = s.toCharArray();

        int index = 0;
        int i = 0;

        while(i < array.length) {
            int j = i;
            while(j < array.length && array[j] == array[i])
                j++;
            index++;
            if(j - i > 1) {
                String temp = j - i + "";
                index += temp.length();
            }
            i = j;
        }
        System.out.println(index);
    }

}
