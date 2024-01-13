package leetcode.dfsOrBfs;

public class S114_flattenBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 用于测试时打印二叉树结构
    public static void printTree(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        printTree(root.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(root.val);
        printTree(root.left, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        printTree(root,0);

        postOrderflatten(root);

        System.out.println("/r");

        printTree(root,0);

    }

    public static void preorder(TreeNode node){

        if(node == null)
            return;


        // PRE = 2 NODE = 4
        TreeNode temp = node.right;
        node.right = node.left;
        node.left = null;

        preorder(node.right);

        while (node.right != null){
            node = node.right;
        }
        node.right = temp;
        preorder(temp);

    }
    public static void flatten(TreeNode root) {
        TreeNode pre = new TreeNode(-1);
        pre.right = root;
        preorder(root);
        pre.right = root;
    }


    public static void postOrderflatten(TreeNode root) {
        dfs(root);
    }
    public static TreeNode[] dfs(TreeNode root){
        if(root == null){
            return new TreeNode[]{null,null};
        }
        if(root.left == null && root.right == null){
            return new TreeNode[]{root,root};
        }
        TreeNode[] left = dfs(root.left);
        TreeNode[] right = dfs(root.right);
        if(root.left == null){
            root.right = right[0];
            return new TreeNode[]{root,right[1]};
        }
        root.left = null;
        if(root.right == null){
            root.right = left[0];
            return new TreeNode[]{root,left[1]};
        }
        root.right = left[0];
        left[1].right = right[0];
        return new TreeNode[]{root,right[1]};
    }


}
