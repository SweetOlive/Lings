package leetcode;

public class leetcode700 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode L2 = new TreeNode(2);
        TreeNode R2 = new TreeNode(7);
        TreeNode L3 = new TreeNode(1);
        TreeNode R3 = new TreeNode(3);
        root.left = L2;
        root.right = R2;
        L2.left = L3;
        L2.right = R3;
        System.out.println(searchBST(root, 2) != null ? searchBST(root, 2).toString() : null);
        System.out.println(searchBST(root, 5) != null ? searchBST(root, 5).toString() : null);


//        TreeNode root = new TreeNode(18);
//        TreeNode L2 = new TreeNode(2);
//        TreeNode R2 = new TreeNode(22);
//        TreeNode L3 = new TreeNode(63);
//        TreeNode R3 = new TreeNode(84);
//        root.left = L2;
//        root.right = R2;
//        R2.right = L3;
//        L3.right = R3;
//        System.out.println(searchBST(root, 63) != null ? searchBST(root, 63).toString() : null);
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        TreeNode tree = null;// 记录相等的树节点
        if (root.val == val)
            tree = root;
        else{
            if (root.left != null)// 遍历左树
                tree = searchBST(root.left, val);
            if (tree != null)
                return tree;
            if (root.right != null)// 遍历右树
                tree = searchBST(root.right, val);
            if (tree != null)
                return tree;
        }
        return tree;
    }
}
