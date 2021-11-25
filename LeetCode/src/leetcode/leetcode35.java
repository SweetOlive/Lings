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
