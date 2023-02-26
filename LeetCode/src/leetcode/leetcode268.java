package leetcode;

import java.util.Arrays;

public class leetcode268 {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3,0,1}));
        System.out.println(missingNumber(new int[]{0,1}));
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(missingNumber(new int[]{0}));
    }

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=i){
                return i;
            }
        }
        return nums.length;
    }

}
