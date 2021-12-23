package leetcode;

public class leetcode108 {


    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    // 官方题解
    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        // 总是选择中间位置右边的数字作为根节点
        //int mid = (left + right + 1) / 2;

        // 选择任意一个中间位置数字作为根节点
        //int mid = (left + right + rand.nextInt(2)) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }


//    自己错误题解
//    public static void main(String[] args) {
//        System.out.println(sortedArrayToBST(new int[]{0,1,2,3,4,5}).toString());
//        sortedArrayToBST(new int[]{0,1,2,3,4,5}).infixOrder();
//        System.out.println(getLeftHeight(sortedArrayToBST(new int[]{0,1,2,3,4,5})));
//        System.out.println(getRightHeight(sortedArrayToBST(new int[]{0,1,2,3,4,5})));
//    }
//
//    public static TreeNode sortedArrayToBST(int[] nums) {
//        TreeNode tree = new TreeNode(Integer.MAX_VALUE);
//        // 创建平衡二叉树
//        for (int i = 0; i < nums.length; i++) {
//            tree = addNodeTree(tree,new TreeNode(nums[i]));
//        }
//        return tree;
//    }
//
//    // 添加节点到二叉树中
//    public static TreeNode addNodeTree(TreeNode root,TreeNode node) {
//        if (root.val == Integer.MAX_VALUE) {
//            root = node;
//        } else {
//            root = addNode(root,node);
//            // 每添加一个节点，就判断一下是否需要旋转
//            if (getRightHeight(root) - getLeftHeight(root) > 1) {  // 如果右子树减去左子树高度大于 1
//                if (getLeftHeight(root.right) > getRightHeight(root.right)) { // 判断是否要双旋转
//                    root = rightRotate(root.right);    // 根节点的右子树右旋
//                }
//                root = leftRotate(root);  // 左旋
//            }
//            if (getLeftHeight(root) - getRightHeight(root) > 1) {    // 如果左子树减去右子树高度大于 1
//                if (getRightHeight(root.left) > getLeftHeight(root.left)) {    // 判断是否要双旋转
//                    root = leftRotate(root.left);    // 根节点的左子树左旋
//                }
//                root = rightRotate(root);
//            }
//        }
//        return root;
//    }
//
//    // 添加结点
//    public static TreeNode addNode(TreeNode root,TreeNode node) {
//        if (node.val < root.val) {
//            if (root.left != null) {
//                addNode(root.left, node);
//            } else {
//                root.left =  node;
//            }
//        } else {
//            if (root.right != null) {
//                addNode(root.right, node);
//            } else {
//                root.right =  node;
//            }
//        }
//        return root;
//    }
//
//    // 求以当前节点为根节点的树的高度
//    public static int getHeight(TreeNode node) {
//        return Math.max(node.left == null ? 0 : getHeight(node.left), node.right == null ? 0 : getHeight(node.right)) + 1;
//    }
//
//    // 获取以当前节点为根节点的左子树高度
//    public static int getLeftHeight(TreeNode node) {
//        if (node.left != null) {
//            return getHeight(node.left);
//        }
//        return 0;
//    }
//
//    // 获取以当前节点为根节点的右子树高度
//    public static int getRightHeight(TreeNode node) {
//        if (node.right != null) {
//            return getHeight(node.right);
//        }
//        return 0;
//    }
//
//    // 以当前节点为根节点将二叉树左旋
//    public static TreeNode leftRotate(TreeNode root) {
//        // 1. 新建一个节点，值为根节点的值
//        TreeNode newNode = new TreeNode(root.val);
//        // 2. 新节点的左指针指向根节点的左子树
//        newNode.left = root.left;
//        // 3. 新节点的右指针指向根节点的右子树的左子树
//        newNode.right = root.right.left;
//        // 4. 将根节点的值改为其右子节点的值
//        root.val = root.right.val;
//        // 5. 根节点的左指针指向新节点
//        root.left = newNode;
//        // 6. 根节点的右指针指向其右子树的右子节点
//        root.right = root.right.right;
//        return root;
//    }
//
//    // 以当前节点为根节点将二叉树右旋
//    public static TreeNode rightRotate(TreeNode root) {
//        // 1. 新建一个节点，值为根节点的值
//        TreeNode newNode = new TreeNode(root.val);
//        // 2. 将新节点的右指针指向根节点的右子树
//        newNode.right = root.right;
//        // 3. 将新节点的左指针指向根节点的左子树的右子树
//        newNode.left = root.left.right;
//        // 4. 将根节点的值改为其左子节点的值
//        root.val = root.left.val;
//        // 5. 将根节点的左指针指向其左子节点的左子树
//        root.left = root.left.left;
//        // 6. 将根节点的右指针指向新节点
//        root.right = newNode;
//        return root;
//    }

}
