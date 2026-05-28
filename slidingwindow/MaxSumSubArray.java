package slidingwindow;

public class MaxSumSubArray {

    // Given an array of positive integers nums and a positive integer k, find the maximum sum of any contiguous subarray of size k.

    public static void main(String[] args) {
        test(new int[]{2, 1, 5, 1, 3, 2}, 3, 9);
        test(new int[]{2, 3, 4, 1, 5}, 2, 7);
    }

    private static void test(int[] nums, int k, int expectedSum){
        int result = findMaxValue2(nums, k);
        if(result==expectedSum){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed. Expected:"+expectedSum+", got:"+result);
        }
    }

    // time complexity: O(n), space complexity: O(1)
    private static int findMaxValue(int[] nums, int k) {
        if(nums==null || nums.length<k){
            return -1; 
        }

        int sum = 0; 
        for(int x=0;x<k;x++){
            sum += nums[x];
        }
        
        int maxSum = sum; 
        for(int i=0, j =k; j<=nums.length-1;j++,i++){
            sum = sum -nums[i]+nums[j];
            if(sum>maxSum){
                maxSum = sum;
            }
        }
        return maxSum;

    }

    private static int findMaxValue2(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1; 
        }

        int maxSum = 0;
        int windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd]; // 1. Add the next element to the window

            // 2. Slide the window once we hit the size 'k'
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[windowStart]; // 3. Subtract the element leaving the window
                windowStart++; // 4. Slide the window start forward
            }
        }

        return maxSum;
    }
}
