package twopointer;

public class DuplicateTwoPointer {

    // Given an integer array nums sorted in ascending order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Return k (the number of unique elements)

    public static void main(String[] args) {
        test(new int[]{1,1,2}, 2);
        test(new int[]{1,1,1}, 1);
        test(new int[]{0,0,1,1,1,2,2,3,3,4}, 5);
    }

    private static void test(int[] nums, int expectedK) {
        int k = removeDuplicates2(nums);
        if (k == expectedK) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed: expected " + expectedK + " but got " + k);
        }
    }
    // Time complexity: O(n) - we traverse the array at most once.
    // Space complexity: O(1) - we use only a constant amount of extra space
    private static int removeDuplicates(int[] nums) {
        if(nums==null){
            return -1;
        }

        if(nums.length==1){
            return 1;
        }

        int counter=0, scanner =1;
        int k=1;

        while (counter<nums.length-1 && scanner<nums.length) {
            if(nums[counter]==nums[scanner]){
                scanner++;
            }else{
                counter=scanner;
                scanner++;
                k++;
            }
        }

        return k;
    }

    // time complexity: O(n) - we traverse the array at most once.
    // space complexity: O(1) - we use only a constant amount of extra space
    private static int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // The first element is always unique, so we start writing at index 1
        int writeIndex = 1; 

        // Scanner explores the rest of the array
        for (int scanner = 1; scanner < nums.length; scanner++) {
            // If the current element is different from the previous element
            if (nums[scanner] != nums[scanner - 1]) {
                nums[writeIndex] = nums[scanner]; // Move the unique element forward
                writeIndex++; // Shift our write boundary
            }
        }

        return writeIndex; // writeIndex naturally equals the count of unique elements 'k'
    }
}
