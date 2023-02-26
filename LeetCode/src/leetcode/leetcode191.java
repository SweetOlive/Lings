package leetcode;

public class leetcode191 {

    public static void main(String[] args) {
        System.out.println(hammingWeight(Integer.parseInt("00000000000000000000000000001011", 2)));
        System.out.println(hammingWeight(Integer.parseInt("00000000000000000000000010000000", 2)));
        System.out.println(hammingWeight(Integer.parseInt("11111111111111111111111111111101", 2)));
    }

    /**
     * 这里取巧了
     * 官方题解是位运算
     * public int hammingWeight(int n) {
     *         int ret = 0;
     *         for (int i = 0; i < 32; i++) {
     *             if ((n & (1 << i)) != 0) {
     *                 ret++;
     *             }
     *         }
     *         return ret;
     *     }
     * 优化
     * public int hammingWeight(int n) {
     *         int ret = 0;
     *         while (n != 0) {
     *             n &= n - 1;
     *             ret++;
     *         }
     *         return ret;
     *     }
     *
     *
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        String toBinaryString = Integer.toBinaryString(n);
        int cnt = 0;
        for (char c : toBinaryString.toCharArray()) {
            if ((int)c -48 == 1){
                cnt++;
            }
        }
        return cnt;
    }
}
