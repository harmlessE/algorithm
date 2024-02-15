package leetcode.techinuqes.trees;
import leetcode.TreeNode;

public class S100_isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p==null || q==null){
            if(p==null && q==null)
                return true;
            else
                return false;
        }

        return (p.val == q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }


}
