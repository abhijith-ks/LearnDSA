package io.abhijith.challenges.amazon;

/**
 * Given 2 strings a and b. a represent the first lane in which vehicles move from left to right.
 * The b represents the second lane in which vehicles move from right to left.
 * Vehicles can be B (bike), C (car), T (truck).
 * collision will occur only between two trucks.
 * Find the probability of collision.
 *
 * Example:
 *
 * a = TCCBCTTB
 * b = BTCCBBTT
 * total number of collisions=7
 * Probability of collision = 7/36
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class TruckProbabilityCollisionAmazon {

    public void findSolution() {
        String s1 = "TCCBCTTB";
        String s2 = "BTCCBBTT";

        int collisionCount = 0, totalCount = 0, accumulateCount = 0;

        for(int i = 0; i < s1.length(); i++) {

            if(s1.charAt(i) == 'T')
                accumulateCount++;

            if(s2.charAt(i) == 'T')
                collisionCount += accumulateCount;
            totalCount += i + 1;
        }

        System.out.println("CollisionCount : " + collisionCount);
        System.out.println("TotalCount : " + totalCount);
        System.out.println("Probability: " + (float)collisionCount / (float)totalCount);

        System.out.println("Different Length Solution");
        differentLengthSolution(s1, s2);
        differentLengthSolution("BTT", "BTCBT");
    }

    public void differentLengthSolution(String s1, String s2) {
        int countTruckB = 0;
        int totalCount;
        int length1 = s1.length();
        int length2 = s2.length();

        if(length1 > length2) {
            totalCount = (length2 * (length2 + 1))/2;
        } else {
            totalCount = (length1 * (length1 + 1))/2 + (length2 - length1) * length1;
        }

        for(int i = 0; i< s2.length(); i++) {
            if(s2.charAt(i) == 'T')
                countTruckB++;
        }
        int collisions = 0;
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            if(s1.charAt(i) == 'T')
                collisions += countTruckB;
            if(s2.charAt(i) == 'T') {
                countTruckB--;
            }
        }
        System.out.println();
        System.out.println("CollisionCount : " + collisions);
        System.out.println("TotalCount : " + totalCount);
        System.out.println("Probability: " + (float)collisions / (float)totalCount);
    }

}
