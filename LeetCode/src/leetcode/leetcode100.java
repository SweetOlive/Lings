package leetcode;

public class leetcode100 {

    public static void main(String[] args) {
        // 输入：p = [1,2,3], q = [1,2,3]
        // 输出：true
        TreeNode a1_1 = new TreeNode(1);
        TreeNode a1_2 = new TreeNode(2);
        TreeNode a1_3 = new TreeNode(3);
        a1_1.left = a1_2;
        a1_1.right = a1_3;

        TreeNode a2_1 = new TreeNode(1);
        TreeNode a2_2 = new TreeNode(2);
        TreeNode a2_3 = new TreeNode(3);
        a2_1.left = a2_2;
        a2_1.right = a2_3;
        System.out.println(isSameTree(a1_1, a2_1));

        // 输入：p = [1,2], q = [1,null,2]
        // 输出：false
        TreeNode b1_1 = new TreeNode(1);
        TreeNode b1_2 = new TreeNode(2);
        b1_1.left = b1_2;

        TreeNode b2_1 = new TreeNode(1);
        TreeNode b2_2 = new TreeNode(2);
        b2_1.right = b2_2;
        System.out.println(isSameTree(b1_1, b2_1));

        // 输入：p = [1,2,1], q = [1,1,2]
        // 输出：false
        TreeNode c1_1 = new TreeNode(1);
        TreeNode c1_2 = new TreeNode(2);
        TreeNode c1_3 = new TreeNode(1);
        c1_1.left = c1_2;
        c1_1.right = c1_3;

        TreeNode c2_1 = new TreeNode(1);
        TreeNode c2_2 = new TreeNode(1);
        TreeNode c2_3 = new TreeNode(2);
        c2_1.left = c2_2;
        c2_1.right = c2_3;
        System.out.println(isSameTree(c1_1, c2_1));

    }

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
