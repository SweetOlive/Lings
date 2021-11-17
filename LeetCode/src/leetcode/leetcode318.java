package leetcode;

/**
 * @Author Lings
 * @Version 1.0
 */
public class leetcode318 {

    public static void main(String[] args) {
//        示例1:
//        输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
//        输出: 16
//        解释: 这两个单词为 "abcw", "xtfn"
        String[] s = {"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(maxProduct(s));
//        示例2:
//        输入: ["a","ab","abc","d","cd","bcd","abcd"]
//        输出: 4
//        解释: 这两个单词为 "ab", "cd"
        String[] s2 = {"a","ab","abc","d","cd","bcd","abcd"};
        System.out.println(maxProduct(s2));
//        示例3:
//        输入: ["a","aa","aaa","aaaa"]
//        输出: 0
//        解释: 不存在这样的两个单词
        String[] s3 = {"a","aa","aaa","aaaa"};
        System.out.println(maxProduct(s3));
    }

    public static int maxProduct(String[] words) {
        /**
         * 题解：意思就是给一个字段串数组，求数组内两个字符串长度之间最大乘积
         * 注意：两个字符串不能包含相同的字母
         * 下面给出的题解 时间复杂度挺大的（1476ms），但是也A了，题目本身应该限制不大
         */
        if (words == null || words.length == 0)
            return 0;
        int max = 0;
        for (int i = 0; i < words.length ;i++){
            char[] c = words[i].toCharArray();
            for (int k = i+1; k < words.length; k++) {
                boolean flag = true;// 判断是否包含相同的字母
                for (int j = 0; j < c.length; j++) {
                    if (words[k].contains(String.valueOf(c[j]))){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    max = Math.max(max,words[k].length() * words[i].length());
                }
            }

        }
        return max;
    }
}
