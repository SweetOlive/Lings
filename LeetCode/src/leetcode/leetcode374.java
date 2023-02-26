package leetcode;

public class leetcode374 {
    private static int pick;

    public static void main(String[] args) {
        pick = 6;
        System.out.println(guessNumber(10));
        pick = 1;
        System.out.println(guessNumber(1));
        pick = 1;
        System.out.println(guessNumber(2));
        pick = 2;
        System.out.println(guessNumber(2));
        pick = 423423;
        System.out.println(guessNumber(1641249143));
    }


    /**
     * 标准二分查找模板
     *   public int guessNumber(int n) {
     *         int left = 1, right = n;
     *         while (left < right) { // 循环直至区间左右端点相同
     *             int mid = left + (right - left) / 2; // 防止计算时溢出
     *             if (guess(mid) <= 0) {
     *                 right = mid; // 答案在区间 [left, mid] 中
     *             } else {
     *                 left = mid + 1; // 答案在区间 [mid+1, right] 中
     *             }
     *         }
     *         // 此时有 left == right，区间缩为一个点，即为答案
     *         return left;
     *     }
     *
     * @param n
     * @return
     */
    public static int guessNumber(int n) {
        int mid = (n - 1) / 2 + 1;
        if (guess(1) == 0) {
            return 1;
        } else if (guess(n) == 0) {
            return n;
        } else if (guess(mid) == 0) {
            return mid;
        } else if (guess(mid) == 1) {
            return guessMy(mid, n);
        } else {
            return guessMy(1, mid);
        }

    }

    public static int guessMy(int s, int e) {
        int mid = (e - s) / 2 + s;
        if (guess(s) == 0) {
            return s;
        } else if (guess(e) == 0) {
            return e;
        } else if (guess(mid) == 0) {
            return mid;
        } else if (guess(mid) == 1) {
            return guessMy(mid, e);
        } else {
            return guessMy(s, mid);
        }
    }

    public static int guess(int num) {
        if (pick == num) {
            return 0;
        } else if (pick < num) {
            return -1;
        }
        return 1;
    }
}
