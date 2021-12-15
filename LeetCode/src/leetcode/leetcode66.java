package leetcode;

import java.util.Arrays;

public class leetcode66 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(plusOne(new int[]{0})));
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9, 9})));

    }

    public static int[] plusOne(int[] digits) {
        // 处理尾数为 9 的特殊情况
        if (digits[digits.length - 1] + 1 == 10) {
            int[] ans = new int[digits.length + 1];
            boolean isAdd = true;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (isAdd) {
                    if (digits[i] + 1 == 10) {
                        ans[i + 1] = 0;
                        ans[i] = 1;
                    } else {
                        ans[i + 1] = digits[i] + 1;
                        isAdd = false;
                    }
                } else {
                    ans[i + 1] = digits[i];
                }
            }
            if (ans[0] == 0){
                System.arraycopy(ans, 1, digits, 0, digits.length);
                return digits;
            }
            return ans;
        }
        // 尾数不为 9
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        return digits;
    }
}
