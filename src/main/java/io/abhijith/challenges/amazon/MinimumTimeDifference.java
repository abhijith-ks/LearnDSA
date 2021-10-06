package io.abhijith.challenges.amazon;

/**
 * Given a list of 24-hour clock time points in "HH:MM" format,
 * return the minimum minutes difference between any two time-points in the list.
 */

public class MinimumTimeDifference {

    public void findSolution() {

        String[] time = {"03:00", "01:00","23:30"};
        int[] timeMinutes = new int[time.length];
        boolean[] bucket = new boolean[1440 + 1];

        for(int i = 0; i < time.length; i++) {
            String[] temp = time[i].split(":");
            timeMinutes[i] = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
            if(bucket[timeMinutes[i]] == true) {
                System.out.println(0);
                return;
            }
            bucket[timeMinutes[i]] = true;
        }

        int first = -1, prev = -1, curr = -1, min = Integer.MAX_VALUE;
        for(int i = 0; i <= 1440; i++) {
            if(bucket[i]) {
               if(prev == -1) {
                   first = i;
                   prev = i;
               } else {
                   curr = i;
                   min = Math.min(min, curr - prev);
                   prev = curr;
               }
            }
        }

        min = Math.min(min, (1440 - curr) + first);
        System.out.println(min);

    }

}
