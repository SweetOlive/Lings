package leetcode;

public class leetcode27 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
        int len = removeElement(nums, val);
        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
            System.out.print(" ");
        }

    }

    public static int removeElement(int[] nums, int val) {
        // 官方题解，双指针
        // 拷贝覆盖
        int ans = 0;
        for(int num: nums) {
            if(num != val) {
                nums[ans] = num;
                ans++;
            }
        }
        return ans;


        //自己写的
//        int len = nums.length;
//        int[] flag = new int[len];
//        int cnt = 0;
//        for (int i = 0; i < len; i++) {
//            if (nums[i] != val)
//                flag[i] = i;
//            else
//                flag[i] = -1;
//        }
//        for (int i = 0; i < len; i++) {
//            if (flag[i] != -1)
//                nums[cnt++] = nums[flag[i]];
//        }
//
//
//        return cnt;
    }
}
