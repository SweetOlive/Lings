package leetcode;

import java.util.HashMap;

public class leetcode202 {

    public static void main(String[] args) {
        // 该题目只要考虑 1 2 情况 不会出现死循环 所以单纯判断是否出现前面出现的数字就可以判断出来
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
    }

    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        map.put(n, 1);

        String s = String.valueOf(n);
        int sum = 0;
        for (char c : s.toCharArray()) {
            Integer integer = (int) c -48;
            sum += integer * integer;
        }
        if (map.get(sum) != null) {
            return false;
        } else {
            return isHappy(sum);
        }
    }

}
