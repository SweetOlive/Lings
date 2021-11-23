package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author Lings
 * @Version 1.0
 */
public class leetcode859 {
    public static void main(String[] args) {
        System.out.println(buddyStrings("ab","ba"));//true
        System.out.println(buddyStrings("ab","ca"));//false
        System.out.println(buddyStrings("aa","bb"));//false
        System.out.println(buddyStrings("ab","ab"));//false
        System.out.println(buddyStrings("aa","aa"));//true
        System.out.println(buddyStrings("abc","abc"));//false
        System.out.println(buddyStrings("aba","aba"));//true
        System.out.println(buddyStrings("abab","abab"));//true
        System.out.println(buddyStrings("aaaaaaabc","aaaaaaacb"));//true
        System.out.println(buddyStrings("","aa"));//false
        System.out.println(buddyStrings("abcaa","abcbb"));//false
        System.out.println(buddyStrings("abcd","cbaa"));//false
        System.out.println(buddyStrings("aaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaa"));//true
        System.out.println(buddyStrings("abcd","badc"));//false
    }



    public static boolean buddyStrings(String A, String B) {
//        * 可以分成两种情况分析：
//        a、标记对比，出现相同字母的个数为2，根据标记，交叉判断A,B是否相等，相等则满足条件
//        b、标记对比，出现相同字母的个数为0，判断单个是否出现相同字母个数等于2或者超过2以上的，则满足条件
        if (A.length() == 0 || B.length() == 0 || A.length() != B.length()) return false;
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        int ans = 0,len = A.length();
        for (int i = 0; i < len; i++) {
            if (a[i] != b[i]) {
                ans++;//标记对比出现不同字母的个数
                list.add(i);//标记出现不同字母的坐标
            }
        }
        if (ans == 2) {//不同字母出现个数为2，判断是否成立
            char[] c = new char[4];
            int cnt = 0;
            for (Integer i : list) {
                c[cnt++] = a[i];
                c[cnt++] = b[i];
            }
            if (c[0] == c[3] && c[1] == c[2]) return true;//交叉判断是否相等，相等则满足条件
        }
        if (ans == 0) {//不同字母出现个数为0，判断是否成立
            HashMap<Character, Integer> m = new HashMap<>();
            for (char c : a) {
                m.merge(c, 1, Integer::sum);
            }
            for (Character key : m.keySet()) {
                Integer val = m.get(key);
                if (val >= 2) return true;//当字符串出现相同字母等于2个或者超过2个以上，则满足替换条件，有一个字母满足条件即可返回true
            }
        }
        return false;
    }

}
