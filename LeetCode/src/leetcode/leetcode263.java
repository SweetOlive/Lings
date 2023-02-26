package leetcode;

import java.util.HashMap;

public class leetcode263 {

    public static void main(String[] args) {
        // 对能被2,3,5整除的数不断除2,3,5，最后剩1就是，剩0就不是，除2可以用位运算替换
        // 注意负数
        System.out.println(isUgly(1));
        System.out.println(isUgly(2));
        System.out.println(isUgly(14));
        System.out.println(isUgly(120));
        System.out.println(isUgly(-2147483648));
        System.out.println(isUgly(1641249143));
        System.out.println(isUgly(8));
    }

    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            // n /= 2;
            // 位运算除2 速度贼快 100%
            n>>=1;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }

    public static boolean isPrime(int num) {
        /*
         * 质数定义：只有1和它本身两个因数的自然数
         *
         * 1. 小于等于1或者是大于2的偶数，直接返回false
         * 2. 2直接返回true
         * 3. 从3开始算起(每次加2，截止为输入值的平方根)，每次输入值除以前者，若出现一个能除尽则直接返回false
         * 4. 全都除不尽，则为质数，返回true
         * */
        if (num <= 1 || num > 2 && num % 2 == 0) {
            return false;
        } else if (num == 2) {
            return true;
        }
        for (int i = 3; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void primeNum(int n, int m, HashMap<Integer, Integer> map) {
        if (map.size() > 3) {
            return;
        }
        if (n >= m) {
            if (n % m == 0) {
                map.put(m, 1);
                primeNum(n / m, m, map);
            } else {
                primeNum(n, m + 1, map);
            }
        }
    }


}
