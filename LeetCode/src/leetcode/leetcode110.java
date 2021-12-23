package leetcode;

public class leetcode110 {

    public static void main(String[] args) {
//        输入：root = [3,9,20,null,null,15,7]
//        输出：true
        TreeNode a1 = new TreeNode(3);
        TreeNode a2 = new TreeNode(9);
        TreeNode a3 = new TreeNode(20);
        TreeNode a4 = new TreeNode(15);
        TreeNode a5 = new TreeNode(7);
        a1.left = a2;
        a1.right = a3;
        a3.left = a4;
        a3.right = a5;
        System.out.println(isBalanced(a1));

//        输入：root = [1,2,2,3,3,null,null,4,4]
//        输出：false
        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(2);
        TreeNode b3 = new TreeNode(2);
        TreeNode b4 = new TreeNode(3);
        TreeNode b5 = new TreeNode(3);
        TreeNode b6 = new TreeNode(4);
        TreeNode b7 = new TreeNode(4);
        b1.left = b2;
        b1.right = b3;
        b2.left = b4;
        b2.right = b5;
        b4.left = b6;
        b4.right = b7;
        System.out.println(isBalanced(b1));

        System.out.println(isBalanced(null));

//        输入：root = [1]
//        输出：true
        TreeNode c1 = new TreeNode(1);
        System.out.println(isBalanced(c1));

//        输入：root = [1,null,2,null,3]
//        输出：false
        TreeNode d1 = new TreeNode(1);
        TreeNode d2 = new TreeNode(2);
        TreeNode d3 = new TreeNode(3);
        d1.right = d2;
        d2.right = d3;
        System.out.println(isBalanced(d1));

//        输入：[1,2,2,3,null,null,3,4,null,null,4]
//        输出：false
        TreeNode e1 = new TreeNode(1);
        TreeNode e2 = new TreeNode(2);
        TreeNode e3 = new TreeNode(2);
        TreeNode e4 = new TreeNode(3);
        TreeNode e5 = new TreeNode(3);
        TreeNode e6 = new TreeNode(4);
        TreeNode e7 = new TreeNode(4);
        e1.left = e2;
        e1.right =e3;
        e2.left = e4;
        e3.right = e5;
        e4.left = e6;
        e5.right = e7;
        System.out.println(isBalanced(e1));

    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left) , maxDepth(root.right)) +1;
    }

}
