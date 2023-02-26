package leetcode;

public class leetcode461 {

    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(1));
//        System.out.println(Integer.toBinaryString(4));
//        System.out.println();
//        System.out.println(Integer.toBinaryString(3));
//        System.out.println(Integer.toBinaryString(1));
//        System.out.println();
//        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
//        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
//        System.out.println(Integer.toBinaryString(1&4));
//        System.out.println(Integer.toBinaryString(1|4));
//        System.out.println(Integer.toBinaryString(1^4));


        System.out.println(hammingDistance(1,4));
        System.out.println(hammingDistance(3,1));
    }

    /**
     *
     * 官方题解 ： return Integer.bitCount(x ^ y);  bitCount 计算二进制中位==1的个数
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {

        // 下面两种自己写的解法都能过，就是效率不行，耗时长，实际上这道题要位运算解最方便，不会，看看官方题解

        return Integer.toBinaryString(x ^ y).replace("0","").length();



//        String x_ = Integer.toBinaryString(x);
//        String y_ = Integer.toBinaryString(y);
//        int len = Math.max(x_.length(), y_.length());
//        if (x_.length() < len) {
//            StringBuilder zero = new StringBuilder();
//            for (int i = 0; i < len - x_.length(); i++) {
//                zero.append("0");
//            }
//            x_ = zero + x_;
//        } else if (y_.length() < len) {
//            StringBuilder zero = new StringBuilder();
//            for (int i = 0; i < len - y_.length(); i++) {
//                zero.append("0");
//            }
//            y_ = zero + y_;
//        }
//        char[] x_c = x_.toCharArray();
//        char[] y_c = y_.toCharArray();
//        int cnt = 0;
//        for (int i = 0; i < len; i++) {
//            if (x_c[i] != y_c[i]){
//                cnt++;
//            }
//        }
//        return cnt;
    }

}
