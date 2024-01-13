package leetcode.dfsOrBfs;

import leetcode.Node;
import leetcode.TreeNode;

public class S236_lowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode anc = new TreeNode();
        dfsContainsPQ(root,p,q,anc);
        return anc;
    }
    // 后序找同时含 P 和 Q 的树

    // java的方法传递都是把内存地址做一份拷贝传递
    // 如果anc 指向的地址变了，就无从影响原来的anc
    // 如果anc 指向的地址中的内容变了，还是会影响原来的anc！！
    public int dfsContainsPQ(TreeNode root, TreeNode p, TreeNode q ,TreeNode anc){
        if(root==null)
            return 0;
        int num = ((root.val == q.val || root.val == p.val) ? 1 : 0 ) + dfsContainsPQ(root.left,p,q,anc) + dfsContainsPQ(root.right,p,q,anc);
        if(num == 2 && anc == null)
            anc = root;
        return num;
    }

//    TreeNode anc = null;
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        dfsContainsPQ(root,p,q);
//        return anc;
//    }
//
//    // 后序找同时含 P 和 Q 的树
//    public int dfsContainsPQ(TreeNode root, TreeNode p, TreeNode q ){
//        if(root==null)
//            return 0;
//        int num = ((root.val == q.val || root.val == p.val) ? 1 : 0 ) + dfsContainsPQ(root.left,p,q) + dfsContainsPQ(root.right,p,q);
//        if(num == 2 && anc == null)
//            anc = root;
//        return num;
//    }


}
