package leetcode;

/**
 * 26 进制
 */
public class leetcode168 {

    public static void main(String[] args) {
        // A
        System.out.println(convertToTitle(1));
        // AB
        System.out.println(convertToTitle(28));
        // ZY
        System.out.println(convertToTitle(701));
        // FXSHRXW
        System.out.println(convertToTitle(2147483647));
    }

    public static String convertToTitle(int columnNumber) {
        String[] s = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        StringBuilder len = new StringBuilder();
        while (columnNumber > 0) {
            // 取余 递归找出最后一位坐标
            int cnt = columnNumber % 26;
            if (cnt == 0) {
                cnt = 26;
            }
            len.insert(0, s[cnt - 1]);
            // 减去计算过的
            columnNumber = (columnNumber - cnt) / 26;
        }
        return len.toString();
    }
}
