package twopointer;


class TargetSum {
    

    //Given an array of integers nums that is already sorted in ascending order, and a target integer target, 
    // find two numbers such that they add up to exactly target.
    // Return the indices of the two numbers (0-indexed) as an integer array of size 2.

    public static void main(String[] args) {
        
        test(new int[]{2,7,11,15}, 9, new int[ ]{0,1});
        test(new int[]{2,3,4}, 6, new int[ ]{0,2});
    }

    private static void test(int[] nums, int target, int[] expected) {
        int[] result = twoSum(nums, target);
        if (result[0] == expected[0] && result[1] == expected[1]) {
            System.out.println(String.format("Target:%d - Test passed", target));
        } else {
            System.out.println(String.format("Target:%d - Test failed: expected %d,%d but got %d,%d", target, expected[0], expected[1], result[0], result[1]));
        }
    }

    // Time complexity: O(n) - we traverse the array at most once.
    // Space complexity: O(1) - we use only a constant amount of extra space
    private static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) {
            return new int[ ]{-1, -1};
        }

        int left =0, right = nums.length -1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum > target){
                right--;
            }else if(sum < target){
                left++;
            }else { 
                return new int[ ]{left, right};
            }
        }

        return new int[ ]{-1, -1};
    }
}