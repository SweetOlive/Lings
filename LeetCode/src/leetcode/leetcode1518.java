package leetcode;

public class leetcode1518 {

    public static void main(String[] args) {
        System.out.println(numWaterBottles(9, 3)); // 13
        System.out.println(numWaterBottles(15, 4)); // 19
        System.out.println(numWaterBottles(5, 5)); // 6
        System.out.println(numWaterBottles(2, 3)); // 2
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int cnt = numBottles;// 记录喝过的瓶数
        int ans = numBottles;// 记录空瓶子数量
        while(ans / numExchange > 0){// 当空瓶子数量无法兑换到一瓶时，跳出循环
            cnt += ans / numExchange;// 累加空瓶子可以兑换的瓶数
            ans = ans / numExchange + ans % numExchange;// 调整空瓶数量
        }
        return cnt;
    }
}
