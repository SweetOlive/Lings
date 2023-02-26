package leetcode;

public class leetcode434 {

    public static void main(String[] args) {
        // 注意，不是字母，还包含不包括空格的其他字符，也就是说一个逗号也算一个
        // 实际上这道题多少有点歧义，看标题说的是单词数，字符也算单词？只能通过测试用例来排除
        System.out.println(countSegments("Hello, my name is John"));
        System.out.println(countSegments(", Hello, my name is John"));
        System.out.println(countSegments(", Hello, my, name, is, John,"));
        System.out.println(countSegments(",  , e, l, lo, my, name, is, John,"));
        System.out.println(countSegments("love live! mu'sic forever"));
        System.out.println(countSegments("a"));

    }

    public static int countSegments(String s) {
        int cnt = 0;
        int ans = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0 ; i < charArray.length;i++) {
            if (Character.isLetter(charArray[i]) || charArray[i] != ' '){
                ans++;
            }else{
                ans = 0;
            }
            if (ans == 1){
                cnt++;
            }
        }
        return cnt;
    }

}
