package leetcode;

public class leetcode104 {

    public static void main(String[] args) {
        TreeNode a1_1 = new TreeNode(3);
        TreeNode a1_2 = new TreeNode(9);
        TreeNode a1_3 = new TreeNode(20);
        TreeNode a1_4 = new TreeNode(15);
        TreeNode a1_5 = new TreeNode(7);
        a1_1.left = a1_2;
        a1_1.right = a1_3;
        a1_3.left = a1_4;
        a1_3.right = a1_5;
        System.out.println(maxDepth(a1_1));

    }

    public static int maxDepth(TreeNode root) {
        int max = 0;
        if (root == null)
            return max;
        max = Math.max(maxDepth(root.left) + 1 , max);
        max = Math.max(maxDepth(root.right) + 1 , max);
        return max;
    }
}
