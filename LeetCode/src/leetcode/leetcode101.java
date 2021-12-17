package leetcode;

public class leetcode101 {

    public static void main(String[] args) {
//          1
//         / \
//        2   2
//       / \ / \
//      3  4 4  3
//      true
        TreeNode a1_1 = new TreeNode(1);
        TreeNode a1_2 = new TreeNode(2);
        TreeNode a1_3 = new TreeNode(2);
        TreeNode a1_4 = new TreeNode(3);
        TreeNode a1_5 = new TreeNode(4);
        TreeNode a1_6 = new TreeNode(4);
        TreeNode a1_7 = new TreeNode(3);
        a1_1.left = a1_2;
        a1_1.right = a1_3;
        a1_2.left = a1_4;
        a1_2.right = a1_5;
        a1_3.left = a1_6;
        a1_3.right = a1_7;
        System.out.println(isSymmetric(a1_1));
//        System.out.println(a1_1.toString());
//        System.out.println(reTree(a1_1).toString());

//          1
//         / \
//        2   2
//         \   \
//          3    3
//        false
        TreeNode b1_1 = new TreeNode(1);
        TreeNode b1_2 = new TreeNode(2);
        TreeNode b1_3 = new TreeNode(2);
        TreeNode b1_4 = new TreeNode(3);
        TreeNode b1_5 = new TreeNode(3);
        b1_1.left = b1_2;
        b1_1.right = b1_3;
        b1_2.right = b1_4;
        b1_3.right = b1_5;
        System.out.println(isSymmetric(b1_1));
//        System.out.println(b1_1.toString());
//        System.out.println(reTree(b1_1).toString());

//         8               8     镜像二叉树
//        / \            /  \
//      6    10        10    6
//     / \   / \      / \   / \
//    5  7  9  11    11  9 7   5
        TreeNode c1_1 = new TreeNode(8);
        TreeNode c1_2 = new TreeNode(6);
        TreeNode c1_3 = new TreeNode(10);
        TreeNode c1_4 = new TreeNode(5);
        TreeNode c1_5 = new TreeNode(7);
        TreeNode c1_6 = new TreeNode(9);
        TreeNode c1_7 = new TreeNode(11);
        c1_1.left = c1_2;
        c1_1.right = c1_3;
        c1_2.left = c1_4;
        c1_2.right = c1_5;
        c1_3.left = c1_6;
        c1_3.right = c1_7;
        System.out.println(isSymmetric(c1_1));
//        System.out.println(c1_1.toString());
//        System.out.println(reTree(c1_1).toString());
    }


    public static boolean isSymmetric(TreeNode root) {
        // 解决方法：获取当前二叉树的镜像二叉树，通过跟镜像二叉树对比是否相等判断是否是对称二叉树
        // 对比两个二叉树是否相等在 Leetcode.100.相同的树 刚好有方法，直接可以拿来用
        // 只要写好镜像二叉树的方法就可以了
        return isSameTree(root,reTree(root));
    }
    // 获取镜像二叉树
    public static TreeNode reTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode tree = new TreeNode(root.val);
        tree.left = reTree(root.right);
        tree.right = reTree(root.left);
        return tree;
    }

    // 判断两个二叉树是否相等
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        boolean isSame = true; // 记录是否相等
        if ((p == null && q != null) || (p != null && q == null))
            return false;
        if (p != null) {
            if (p.val != q.val) // 校验值是否相等
                return false;
            isSame = isSameTree(p.left, q.left);
            if (!isSame) // 不等直接返回跳出递归
                return false;
            isSame = isSameTree(p.right, q.right);
            if (!isSame) // 不等直接返回跳出递归
                return false;
        }
        return isSame;
    }



}
