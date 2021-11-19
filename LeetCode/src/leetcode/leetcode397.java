package leetcode;

/**
 * @Author Lings
 * @Version 1.0
 */
public class leetcode397 {
    public static void main(String[] args) {
//        给定一个正整数n ，你可以做如下操作：
//        如果n是偶数，则用n / 2替换n 。
//        如果n是奇数，则可以用n + 1或n - 1替换n 。
//        n变为 1 所需的最小替换次数是多少？
//
//        示例 1：
//        输入：n = 8
//        输出：3
//        解释：8 -> 4 -> 2 -> 1
//
//        示例 2：
//        输入：n = 7
//        输出：4
//        解释：7 -> 8 -> 4 -> 2 -> 1
//        或 7 -> 6 -> 3 -> 2 -> 1
//        示例 3：
//
//        输入：n = 4
//        输出：2
//
//        提示：
//        1 <= n <= 2^31 - 1
        /*
         * 题意：意思很简单，但是没想到解决的，底下题解是找了一个暴力解决的
         * 官方题解：用递归或者贪心或者搜索，其实要找出一个共性点
         * 暴力、递归、贪心、位运算、DFS搜索
         */

        System.out.println(integerReplacement(8));
        System.out.println(integerReplacement(7));
        System.out.println(integerReplacement(4));

    }

    public static int integerReplacement(int n) {
        //记录转换操作的次数
        int cnt = 0;
        //将n拷贝到long数据类型中以防数据类型溢出
        long num = n;
        //判断循环执行的条件（只有当num=1时退出循环）
        while (num != 1) {
            //如果当前num为偶数
            if (num % 2 == 0) {
                //则按照题意，对num进行减半
                num /= 2;
                //操作数自增一次
                cnt++;
            } //如果当前num为奇数
            else {
                //判断num的自减操作能否在下一步中产生偶数（其中需要排除num已经为2的情况）
                if (((num - 1) / 2) % 2 == 0 || (num - 1) / 2 == 1) {
                    //上述条件满足则执行自减操作
                    num -= 1;
                    //操作数自增一次
                    cnt++;
                } //如果num的自增操作能够使下一步中继续产生偶数，则对num进行自增操作
                else {
                    //上述条件满足则执行一次自增操作
                    num += 1;
                    //操作数自增一次
                    cnt++;
                }
            }
        }
        return cnt;//返回最终结果
    }
}
