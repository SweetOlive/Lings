package leetcode;

public class leetcode28 {

    public static void main(String[] args) {
        System.out.println(strStr("hello","ll"));
        System.out.println(strStr("aaaaa","bba"));
        System.out.println(strStr("",""));
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
