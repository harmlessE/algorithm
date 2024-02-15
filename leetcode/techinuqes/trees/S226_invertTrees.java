package leetcode.techinuqes.trees;

import leetcode.ListNode;
import leetcode.TreeNode;

public class S226_invertTrees {



    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;

    }

    private void dfs(TreeNode root) {
        if(root == null)
            return;
        dfs(root.left);
        dfs(root.right);

        if(root.left==null && root.right==null)
            return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }


}
