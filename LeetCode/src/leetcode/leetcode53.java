package leetcode;

public class leetcode53 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
        System.out.println(maxSubArray(new int[]{1})); // 1
        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8}));// 23
        System.out.println(maxSubArray(new int[]{-1, 0, -2}));// 0
        System.out.println(maxSubArray(new int[]{-2, -3, -1}));// -1
        System.out.println(maxSubArray(new int[]{3, 2, -3, -1, 1, -3, 1, -1}));// 5
    }

    public static int maxSubArray(int[] nums) {
        // 官方题解：动态规划、分治算法
//        int pre = 0, maxAns = nums[0];
//        for (int x : nums) {
//            pre = Math.max(pre + x, x);
//            maxAns = Math.max(maxAns, pre);
//        }
//        return maxAns;


        // 我自己解法，贪心算法，需考虑整个数组都是小于0的情况
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2) {
            return Math.max(Math.max(nums[0], nums[1]), nums[0] + nums[1]);
        }

        int ans = nums[0]; // 取所有值的最大值
        int max = nums[0]; // 连续子数组最大值
        int sum = 0;// 连续子数组求和
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans = Math.max(ans, nums[i]);
            if (sum > 0){
                if (sum >= max)// 大于0，判断当前子数组和是否大于之前的
                    max = sum;
            } else {
                sum = 0;// 不大于0,重置为0，开始新子数组求和
            }

        }
        return Math.max(ans, max);// 排除连续子数组最大值为负数情况，获取最大值
    }
}
