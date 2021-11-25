package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class leetcode2032 {
    public static void main(String[] args) {
        System.out.println(twoOutOfThree(new int[]{1,1,3,2},new int[]{2,3},new int[]{3})); // [3,2]
        System.out.println(twoOutOfThree(new int[]{3,1},new int[]{2,3},new int[]{1,2})); // [2,3,1]
        System.out.println(twoOutOfThree(new int[]{1,2,2},new int[]{4,3,3},new int[]{5}));// []
    }
    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        // 题解：取值两两数组之间出现的重复数字，直接筛选了
        // 题外话：注意提示 只取1-100的数值。完全不用开那么多集合，直接用int[101]的数据就可以了
        //  1 <= nums1.length, nums2.length, nums3.length <= 100
        //  1 <= nums1[i], nums2[j], nums3[k] <= 100
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        HashSet<Integer> set3 = new HashSet<>();
        HashMap<Integer,Integer> m = new HashMap<>();
        for (int i : nums1) set1.add(i);
        for (int i : nums2) set2.add(i);
        for (int i : nums3) set3.add(i);
        for (Integer i : set1) m.merge(i, 1, Integer::sum);
        for (Integer i : set2) m.merge(i, 1, Integer::sum);
        for (Integer i : set3) m.merge(i, 1, Integer::sum);
        for (Integer key : m.keySet()){
           if (m.get(key) >= 2)
               list.add(key);
        }
        return list;
    }
}
