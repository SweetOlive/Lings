package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode111 {

    public static void main(String[] args) {

//        输入：root = [3,9,20,null,null,15,7]
//        输出：2
//        TreeNode a1 = new TreeNode(3);
//        TreeNode a2 = new TreeNode(9);
//        TreeNode a3 = new TreeNode(20);
//        TreeNode a4 = new TreeNode(15);
//        TreeNode a5 = new TreeNode(7);
//        a1.left = a2;
//        a1.right = a3;
//        a3.left = a4;
//        a3.right = a5;
//        System.out.println(minDepth(a1));

        TreeNode d1 = new TreeNode(1);
        TreeNode d2 = new TreeNode(2);
        TreeNode d3 = new TreeNode(3);
        TreeNode d4 = new TreeNode(4);
        TreeNode d5 = new TreeNode(5);
        d1.right = d2;
        d2.right = d3;
        d3.right = d4;
        d4.right = d5;
        System.out.println(minDepth(d1));

    }

    // 自己题解，耗时大
    public static int minDepth(TreeNode root) {
        int min;
        if (root == null)
            return 0;
        if (maxDepth(root.left) != 0 && maxDepth(root.right) != 0)
            min = Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        else if (maxDepth(root.left) == 0)
            min = minDepth(root.right) + 1;
        else
            min = minDepth(root.left) + 1;
        return min;
    }

    // 求树的最大深度
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // 官方题解
    // 深度有限搜索（递归）
//    class Solution {
//        public int minDepth(TreeNode root) {
//            if (root == null) {
//                return 0;
//            }
//
//            if (root.left == null && root.right == null) {
//                return 1;
//            }
//
//            int min_depth = Integer.MAX_VALUE;
//            if (root.left != null) {
//                min_depth = Math.min(minDepth(root.left), min_depth);
//            }
//            if (root.right != null) {
//                min_depth = Math.min(minDepth(root.right), min_depth);
//            }
//
//            return min_depth + 1;
//        }
//    }


    // 广度优先搜索
//    class Solution {
//        class QueueNode {
//            TreeNode node;
//            int depth;
//
//            public QueueNode(TreeNode node, int depth) {
//                this.node = node;
//                this.depth = depth;
//            }
//        }
//
//        public int minDepth(TreeNode root) {
//            if (root == null) {
//                return 0;
//            }
//
//            Queue<QueueNode> queue = new LinkedList<QueueNode>();
//            queue.offer(new QueueNode(root, 1));
//            while (!queue.isEmpty()) {
//                QueueNode nodeDepth = queue.poll();
//                TreeNode node = nodeDepth.node;
//                int depth = nodeDepth.depth;
//                if (node.left == null && node.right == null) {
//                    return depth;
//                }
//                if (node.left != null) {
//                    queue.offer(new QueueNode(node.left, depth + 1));
//                }
//                if (node.right != null) {
//                    queue.offer(new QueueNode(node.right, depth + 1));
//                }
//            }
//            return 0;
//        }
//    }


}
