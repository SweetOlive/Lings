package leetcode;

public class leetcode70 {


    public static void main(String[] args) {
        System.out.println(climbStairs(2)); // 2
        System.out.println(climbStairs(3)); // 3
        System.out.println(climbStairs(4)); // 5
        System.out.println(climbStairs(5)); // 8
        System.out.println(climbStairs(6)); // 13
        System.out.println(climbStairs(7)); // 21
        System.out.println(climbStairs(45)); // 1836311903
        System.out.println(climbStairs(30)); // 1836311903

    }
    private static int[] a = new int[10000]; // 记忆数组
    public static int climbStairs(int n) {
        // 经过对 2 3 4 5 6 阶梯的计算可以得到 2 3 5 8 13 ，结合 1 2 阶梯得到 1 2，可以很明显的看出这是斐波那契函数，即 f(n) = f(n-1) + f(n-2)
        // 但是直接用斐波那契函数会超时，所以定义一个记忆数组记忆已经计算过的阶数
        // n 如果很大的话 记忆数组就没用了，要 用矩阵快速幂 的方法计算
        if (n == 1 || n == 2)
            return n;
        if (a[n] != 0)// 存在已经计算过的阶梯 ，直接返回，大大节省时间
            return a[n];
        a[n] = climbStairs(n-1) + climbStairs(n - 2);
        return a[n];
    }

}
