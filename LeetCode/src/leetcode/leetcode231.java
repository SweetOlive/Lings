package leetcode;

public class leetcode231 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(3));
        System.out.println(isPowerOfTwo(4));
        System.out.println(isPowerOfTwo(5));
    }

    /**
     * class Solution {
     *     public boolean isPowerOfTwo(int n) {
     *         return n > 0 && (n & (n - 1)) == 0;
     *     }
     * }
     * class Solution {
     *     static final int BIG = 1 << 30;
     *
     *     public boolean isPowerOfTwo(int n) {
     *         return n > 0 && BIG % n == 0;
     *     }
     * }
     *
     * 其他
     * 打表法
     *
     * 二进制数只有最高位为 1 判断位数即可 return n > 0 and bin(n).count('1') == 1
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        // 被卡 0 了， 卧槽
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n = n >> 1;
        }
        return n == 1;
    }
}
