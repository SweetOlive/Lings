package leetcode;

public class leetcode35 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6},5));// 2
        System.out.println(searchInsert(new int[]{1,3,5,6},2));// 1
        System.out.println(searchInsert(new int[]{1,3,5,6},7));// 4
        System.out.println(searchInsert(new int[]{1,3,5,6},0));// 0
        System.out.println(searchInsert(new int[]{1},0));// 0
    }

    public static int searchInsert(int[] nums, int target) {
        // 最优解是二分查找，没仔细看题意
        // 题意提示：nums 为无重复元素的升序排列数组 ，故可用二分
        //下面是暴力解
        if (nums.length == 1)
            return target <= nums[0] ? 0 : 1;
        int cnt = 0;
        boolean flag = true;
        for (int i = 0; i < nums.length-1; i++) {
            if (target <= nums[i]){
                cnt = i;
                flag = false;
                break;
            }
        }
        if (flag)
            cnt = target <= nums[nums.length-1] ? nums.length-1 : nums.length;
        return cnt;
    }
}
