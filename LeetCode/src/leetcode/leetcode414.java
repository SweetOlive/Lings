package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class leetcode414 {
    public static void main(String[] args) {
        // 1
        System.out.println(thirdMax(new int[]{3, 2, 1}));
        // 2
        System.out.println(thirdMax(new int[]{1, 2}));
        // 1
        System.out.println(thirdMax(new int[]{2, 2, 3, 1}));

        System.out.println(thirdMax(new int[]{1, 2, -2147483648}));
    }

    public static int thirdMax(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();

        quickRow(nums, 0, nums.length - 1);
        if (nums.length < 3) {
            return nums[nums.length - 1];
        } else {
            int ans = nums[nums.length-1];
            int cnt = 0;
            for (int i = nums.length-1; i >= 0; i--) {
                if (ans != nums[i]){
                    ans = Math.min(ans,nums[i]);
                    cnt++;
                }
                if (cnt == 2){
                    return nums[i];
                }
            }
            return nums[nums.length-1];
        }
    }

    //快排实现方法
    public static void quickRow(int[] array, int low, int high) {
        int i, j, pivot;
        //结束条件
        if (low >= high) {
            return;
        }
        i = low;
        j = high;
        //选择的节点，这里选择的数组的第一数作为节点
        pivot = array[low];
        while (i < j) {
            //从右往左找比节点小的数，循环结束要么找到了，要么i=j
            while (array[j] >= pivot && i < j) {
                j--;
            }
            //从左往右找比节点大的数，循环结束要么找到了，要么i=j
            while (array[i] <= pivot && i < j) {
                i++;
            }
            //如果i!=j说明都找到了，就交换这两个数
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        //i==j一轮循环结束，交换节点的数和相遇点的数
        array[low] = array[i];
        array[i] = pivot;
        //数组“分两半”,再重复上面的操作
        quickRow(array, low, i - 1);
        quickRow(array, i + 1, high);
    }
}
