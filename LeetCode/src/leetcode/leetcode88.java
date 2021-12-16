package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class leetcode88 {

    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int m = 3;
//        int[] nums2 = {2, 5, 6};
//        int n = 3;
//        merge(nums1, m, nums2, n);
//        System.out.println(Arrays.toString(nums1));

//        int[] nums1 = {1};
//        int m = 1;
//        int[] nums2 = {};
//        int n = 0;
//        merge(nums1, m, nums2, n);
//        System.out.println(Arrays.toString(nums1));

//        int[] nums1 = {0};
//        int m = 0;
//        int[] nums2 = {1};
//        int n = 1;
//        merge(nums1, m, nums2, n);
//        System.out.println(Arrays.toString(nums1));

        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int m = 3;
        int[] nums2 = {1, 2, 3};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));


    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length - m >= 0)
            System.arraycopy(nums2, 0, nums1, m, nums1.length - m);
        Arrays.sort(nums1);
    }
}
