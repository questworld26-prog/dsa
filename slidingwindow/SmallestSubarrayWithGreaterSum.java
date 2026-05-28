package slidingwindow;

public class SmallestSubarrayWithGreaterSum {


    // Given an array of positive integers nums and a target positive integer target, find the minimal length of a contiguous subarray of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

    public static void main(String[] args) {
        test(new int[]{2, 1, 5, 2, 3, 2}, 7, 2);
        test(new int[]{2, 1, 5, 2, 8}, 7, 1);
        test(new int[]{3, 4, 1, 1, 6}, 8, 3);
        test(new int[]{1, 1, 6, 0}, 7, 2);
    }

    private static void test(int[] nums, int target, int expected) {
        int result = findMinSubArrayLen(nums, target);
        System.out.println("Input: " + java.util.Arrays.toString(nums) + ", Target: " + target);
        if (result == expected) {
            System.out.println("Test passed");
        } else {
            System.out.println("Failed Expected: " + expected + ", Got: " + result);
        }
        System.out.println();
    }

    // there is a bug in this code. {1, 1, 6, 0} will return 3 not 2. The window is not reduced to check if there is a smaller window that satisfies the condition.
    // public static int findMinSubArrayLen(int[] nums, int target) {
    //    if (nums == null) {
    //         return -1; 
    //     }

    //     int sum = 0;
    //     int windowSum = 0;
    //     int windowStart = 0;
    //     int minLength = Integer.MAX_VALUE;

    //     for(int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
    //        sum+=nums[windowEnd];

    //        if(sum>=target){
    //         int length =windowEnd-windowStart+1;
    //         minLength = minLength > length ? length : minLength;
    //         windowStart=windowEnd;
    //         sum = nums[windowEnd];
    //        }
    //     }
    //     if(sum>=target){
    //         int length =nums.length-windowStart;
    //         minLength = minLength > length ? length : minLength;
    //     }


    //     return minLength == Integer.MAX_VALUE ? 0 : minLength;
    // }

    public static int findMinSubArrayLen(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0; 
        }

        int currentWindowSum = 0;
        int minLength = Integer.MAX_VALUE;
        int windowStart = 0;

        
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            currentWindowSum += nums[windowEnd];

            
            while (currentWindowSum >= target) {
                
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                
                currentWindowSum -= nums[windowStart];
                windowStart++;
            }
        }

        // If minLength wasn't updated, it means no valid subarray was found
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
