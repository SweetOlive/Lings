package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetcode2357 {

    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{0}));
        System.out.println(minimumOperations(new int[]{1,5,0,3,5}));
    }

    /**
     * 简单模拟  +  贪心
     * 实际上就是求不同数的个数（排除0）
     * @param nums
     * @return
     */
    public static int minimumOperations(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                s.add(nums[i]);
            }
        }
        return s.size();
    }

}
