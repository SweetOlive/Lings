package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode119 {

    public static void main(String[] args) {
//        for (int i = 0; i < 33; i++) {
//            System.out.println(getRow(i+1));
//        }
        System.out.println(getRow(3));
    }

    // 最优解，线性递推
//    public List<Integer> getRow(int rowIndex) {
//        List<Integer> row = new ArrayList<Integer>();
//        row.add(1);
//        for (int i = 1; i <= rowIndex; ++i) {
//            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
//        }
//        return row;
//    }

    // 我这暴力解法比官方递推法还省时一点，哈哈
    public static List<Integer> getRow(int rowIndex) {
        rowIndex++;
        int[][] a = new int[rowIndex][rowIndex];
        for (int i = 0; i < rowIndex; i++)
            a[i] = sanjiao(i + 1, a);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a[rowIndex - 1].length; i++)
            list.add(a[rowIndex - 1][i]);
        return list;
    }

    public static int[] sanjiao(int row, int[][] s) {
        int[][] a = new int[row][row];
        if (row == 1) {
            a[0][0] = 1;
            return a[0];
        }
        if (row == 2) {
            a[0][0] = 1;
            a[1][0] = 1;
            a[1][1] = 1;
            return a[1];
        }
        a[row - 1][0] = 1;
        a[row - 1][row - 1] = 1;
        for (int i = 1; i < row - 1; i++) {
            a[row - 1][i] = s[row - 2][i - 1] + s[row - 2][i];
        }
        return a[row - 1];
    }
}
