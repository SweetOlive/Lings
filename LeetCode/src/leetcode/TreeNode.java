package leetcode;

public class TreeNode {
    int val; // 值
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
    // 中序遍历：左->根->右
    public void infixOrder(){
        if (this.left != null){ // 先左子节点
            this.left.infixOrder();
        }
        System.out.print(this.val + " ");   // 再根节点
        if (this.right != null){
            this.right.infixOrder();    // 最后右子节点
        }
    }

    // 求树的最大深度
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left) , maxDepth(root.right)) +1;
    }

}