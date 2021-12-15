package leetcode;

public class leetcode58 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
        System.out.println(lengthOfLastWord("    joyboy      "));
        System.out.println(lengthOfLastWord("    joyboy    a     "));
        System.out.println(lengthOfLastWord("          "));
        System.out.println(lengthOfLastWord(null));
    }
    public static int lengthOfLastWord(String s) {
        if (s == null)
            return 0;
        String[] ans = s.split(" ");
        return ans.length > 0 ? ans[ans.length-1].length() : 0;
    }
}
