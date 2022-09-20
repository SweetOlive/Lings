package leetcode;

public class leetcode112 {

    public static void main(String[] args) {
        TreeNode d1 = new TreeNode(5);
        TreeNode d2 = new TreeNode(4);
        TreeNode d3 = new TreeNode(11);
        TreeNode d4 = new TreeNode(7);
        TreeNode d5 = new TreeNode(2);

        TreeNode d6 = new TreeNode(8);
        TreeNode d7 = new TreeNode(13);
        TreeNode d8 = new TreeNode(4);
        TreeNode d9 = new TreeNode(1);

        d1.left = d2;
        d1.right = d6;

        d2.left = d3;
        d3.left = d4;
        d3.right = d5;

        d6.left = d7;
        d6.right = d8;
        d8.right = d9;
        System.out.println(hasPathSum(d1, 22));
    }


    // 记录遍历节点值
    private static int sum = 0;

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        // 树为空 直接跳出
        if (root == null) {
            return false;
        }
        // 累加值
        sum += root.val;
        // 如果左右子节点都为空 则到达最小节点 判断遍历结果是否跟预期值相等
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                return true;
            }
        }
        if (root.left != null) {
            // 不相等减去子节点的值
            if (!hasPathSum(root.left, targetSum)) {
                sum -= root.left.val;
            } else {
                return true;
            }
        }
        if (root.right != null) {
            // 不相等减去子节点的值
            if (!hasPathSum(root.right, targetSum)) {
                sum -= root.right.val;
            } else {
                return true;
            }
        }
        return false;
    }

}
