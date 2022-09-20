package leetcode;

import java.util.Arrays;

public class leetcode169 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3, 3}));
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(majorityElement(new int[]{3, 3, 4}));
    }

    /**
     * 找出出现次数最多的数字
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        // 方法二
        int[] arr = Arrays.stream(nums).sorted().toArray();
        return arr[arr.length / 2];
        // 方法一
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.get(nums[i]) == null) {
//                map.put(nums[i], 1);
//            } else {
//                map.put(nums[i], map.get(nums[i]) + 1);
//            }
//        }
//        int ans = Integer.MIN_VALUE;
//        int cnt = Integer.MAX_VALUE;
//        for (Integer key : map.keySet()) {
//            if (map.get(key) > ans) {
//                cnt = key;
//                ans = map.get(key);
//            }
//        }
//        return cnt;
    }
}
