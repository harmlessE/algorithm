package leetcode.techinuqes.trees;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class S105_buildTreeFromqianandzhong {
    Map<Integer,Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {

        if(p_start == p_end)
            return null;


        int root_index = map.get(preorder[p_start]);

        int leftSubTreeNum = root_index - i_start;

        TreeNode root = new TreeNode(preorder[p_start]);

        root.left = buildTreeHelper(preorder,p_start + 1, p_start + leftSubTreeNum + 1, inorder, i_start, root_index);

        root.right = buildTreeHelper(preorder,root_index + leftSubTreeNum + 1, p_end, inorder, root_index + 1, i_end );
        return root;

    }

}
