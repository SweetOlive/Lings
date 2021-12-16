package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode94 {
    public static void main(String[] args) {
        // 输入：root = [1,null,2,3]
        // 输出：[1,3,2]
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.right = n2;
        n2.left = n3;
        System.out.println(inorderTraversal(n1));

        // 输入：root = []
        // 输出：[]
        list = new ArrayList<>();
        System.out.println(inorderTraversal(null));

        // 输入：root = [1]
        // 输出：[1]
        list = new ArrayList<>();
        TreeNode m1 = new TreeNode(1);
        System.out.println(inorderTraversal(m1));

        // 输入：root = [1,2]
        // 输出：[2,1]
        list = new ArrayList<>();
        TreeNode c1 = new TreeNode(1);
        TreeNode c2 = new TreeNode(2);
        c1.left = c2;
        System.out.println(inorderTraversal(c1));

        // 输入：root = [1,null,2]
        // 输出：[1,2]
        list = new ArrayList<>();
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        a1.right = a2;
        System.out.println(inorderTraversal(a1));

    }
    private static List<Integer> list = new ArrayList<>();
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return list;
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
}
