package leetcode;

public class leetcode278 {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2));
    }

    /**
     * 二分查找解法 还是看看官方题解吧
     *  public int firstBadVersion(int n) {
     *         int left = 1, right = n;
     *         while (left < right) { // 循环直至区间左右端点相同
     *             int mid = left + (right - left) / 2; // 防止计算时溢出
     *             if (isBadVersion(mid)) {
     *                 right = mid; // 答案在区间 [left, mid] 中
     *             } else {
     *                 left = mid + 1; // 答案在区间 [mid+1, right] 中
     *             }
     *         }
     *         // 此时有 left == right，区间缩为一个点，即为答案
     *         return left;
     *  }
     * @param n
     * @return
     */
    public static int firstBadVersion(int n) {
        int mid = n / 2 ;
        if (isBadVersion(mid)) {
            return twoSplit(1, mid);
        } else {
            return twoSplit(mid, n);
        }
    }

    private static int twoSplit(int s, int e) {
        if (e == s){
            return e;
        }
        if (isBadVersion(e) && !isBadVersion(s) && e - s == 1) {
            return e;
        }
        int mid = s + (e-s) / 2;
        if (isBadVersion(mid)) {
            return twoSplit(s, mid);
        } else {
            return twoSplit(mid, e);
        }
    }

    public static boolean isBadVersion(int n) {
        return n >= 1;
    }

}
