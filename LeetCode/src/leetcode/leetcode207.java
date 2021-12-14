package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;


public class leetcode207 {
    public static void main(String[] args) {
//        System.out.println(canFinish(2, new int[][]{{1, 0}}));// true
//        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));// false
//        System.out.println(canFinish(3, new int[][]{{1, 0}, {1, 2}}));// true
//        System.out.println(canFinish(3, new int[][]{{1, 0}, {0, 2},{2, 1}}));// false
//        System.out.println(canFinish(3, new int[][]{{1, 0}, {1, 2},{0, 1}}));// false
//        System.out.println(canFinish(4, new int[][]{{0, 1}, {0, 2},{1, 3},{3, 0}}));// false
//        System.out.println(canFinish(20, new int[][]{{0, 10}, {3, 18},{5, 5},{6, 11},{13,1},{15,1},{17,4}}));// false
        System.out.println(canFinish(3, new int[][]{{1, 0}, {2, 0}, {0, 2}}));// false
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
//        // 判断是否出现 相同互反数组，出现则无法完成修完
//        for (int i = 0; i < prerequisites.length; i++) {
//            for (int j = 0; j < prerequisites.length; j++) {
//                if (prerequisites[j][0] == prerequisites[i][1] && prerequisites[j][1] == prerequisites[i][0])
//                    return false;
//            }
//        }
//        // 循环判断是否出现头尾数组，出现则无法修完
//        for (int i = 0; i < prerequisites.length; i++) {
//            int x = prerequisites[i][0];
//            int y = prerequisites[i][1];
//            if (x == y)
//                return false;
//            for (int j = 0; j < prerequisites.length; j++) {
//                for (int k = 0; k < prerequisites.length && k != i; k++) {
//                    if (prerequisites[k][1] == x && prerequisites[k][0] == y)
//                        return false;
//                    else
//                        x = prerequisites[k][0];
//                }
//            }
//        }
//        return true;

        // 官方题解 拓扑排序 深度搜索
        // 题意理解了，上面暴力超时了，没解决
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites)
            adjacency.get(cp[1]).add(cp[0]);
        for (int i = 0; i < numCourses; i++)
            if (!dfs(adjacency, flags, i)) return false;
        return true;

    }

    private static boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) return false;
        if (flags[i] == -1) return true;
        flags[i] = 1;
        for (Integer j : adjacency.get(i))
            if (!dfs(adjacency, flags, j)) return false;
        flags[i] = -1;
        return true;
    }
}