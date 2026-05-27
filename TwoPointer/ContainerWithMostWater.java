package twopointer;

public class ContainerWithMostWater {

    // You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

    // Find two lines that together with the x-axis form a container, such that the container contains the most water.

    // Return the maximum amount of water a container can store.
    // https://leetcode.com/problems/container-with-most-water/description/

    public static void main(String[] args) {
        test(new int[]{1,8,6,2,5,4,8,3,7}, 49);
        test(new int[]{1,1}, 1);
    }

    private static void test(int[] height, int expected) {
        int result = maxArea(height);
        if (result == expected) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed: expected " + expected + " but got " + result);
        }
    }

    private static int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0; // Standard fallback
        }

        int i = 0, j = height.length - 1;
        int maxArea = 0;
        
        while (i < j) {
            // 1. Calculate area with current boundaries
            int currentHeight = Math.min(height[i], height[j]);
            int currentWidth = j - i;
            int area = currentHeight * currentWidth;
            
            // 2. Track the maximum
            maxArea = Math.max(maxArea, area);
            
            // 3. Move the pointer that is limiting us (the shorter one)
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }
}
