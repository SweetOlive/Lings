package leetcode;

public class leetcode1446 {
    public static void main(String[] args) {
        System.out.println(maxPower("leetcode"));
        System.out.println(maxPower("abbcccddddeeeeedcba"));
        System.out.println(maxPower("triplepillooooow"));
        System.out.println(maxPower("hooraaaaaaaaaaay"));
        System.out.println(maxPower("tourist"));
        System.out.println(maxPower("j"));
    }
    public static int maxPower(String s) {
        // 题解：就是找连续最长相同字母的长度
        char[] c = s.toCharArray();
        char cnt = c[0];
        int count = 1;
        int max = 0;
        for (int i = 1; i < c.length; i++) {
            if (cnt == c[i]){
                count++;
            }else{
                cnt = c[i];
                max = Math.max(count,max);
                count = 1;
            }
        }
        max = Math.max(count,max);
        return max;
    }
}
