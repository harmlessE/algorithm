package leetcode.dfsOrBfs;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S1315_sumEvenGrandparent {


    // 祖父节点可以根据二叉树的性质来求
    // dfs中 队列内上一个元素就是父亲 再上一个元素就是祖父
        //  0
        // 1 x
        //2 x x x
    //  3  x

    int sum = 0;
    List<TreeNode> path = new ArrayList<>();
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root);
        return sum;
    }
    public void dfs (TreeNode root){
        if(root==null)
            return;
        // null的时候不管 也加入到path
        path.add(root);
        if(path.size() >= 3  && path.get(path.size()-3).val % 2 == 0 )
            sum += root.val;
        dfs(root.left);
        dfs(root.right);

        path.removeLast();

    }

}
