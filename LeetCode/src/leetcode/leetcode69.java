package leetcode;

public class leetcode69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(0)); // 0
        System.out.println(mySqrt(1)); // 1
        System.out.println(mySqrt(2)); // 1
        System.out.println(mySqrt(3)); // 1
        System.out.println(mySqrt(2147395599)); // 46339
//        System.out.println(mySqrt(4)); // 2
//        System.out.println(mySqrt(8)); // 2 -- 8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去
//        System.out.println(mySqrt(32)); // 5
//        System.out.println(mySqrt(1000)); // 31
//        System.out.println(mySqrt(6666)); // 81
    }
    public static int mySqrt(int x) {
        // 二分法
        if (x == 1 || x == 0)
            return x;
        int high = x;
        int low = 0;
        int guess = (high + low) / 2;
        int history = 0;
        while((long)guess * guess != x && history != guess){ // 加 long 避免int * int溢出 超时
            history = guess; // 记录上次的值
            if ((long)guess * guess > x){
                high = guess;
            }else {
                low = guess;
            }
            guess = (high + low) / 2;
        }
        return guess;
    }

}
