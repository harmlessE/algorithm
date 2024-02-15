package leetcode.techinuqes.trees;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {



    private int idx;
    private List<Integer> arr;

    public BSTIterator(TreeNode root) {
        arr = new ArrayList<>();
        inOrder(root);
    }

    private void inOrder(TreeNode root) {
        if(root == null)
            return;
        inOrder(root.left);
        arr.add(root.val);
        inOrder(root.right);
    }

    public int next() {
        return arr.get(idx++);
    }

    public boolean hasNext() {
        return idx < arr.size();
    }
}
