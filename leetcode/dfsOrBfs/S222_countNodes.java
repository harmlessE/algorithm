package leetcode.dfsOrBfs;

import leetcode.TreeNode;

public class S222_countNodes {




    // solution 1
    public int countNodes(TreeNode root) {
        return dfs1(root);
    }

    int dfs1(TreeNode root){
        if (root == null){
            return 0;
        }
        return dfs1(root.left) + dfs1(root.right) + 1;
    }

    // 利用完全二叉树的性质来做  满二叉树节点数为2^h -1
    // 自未知->已知传递 递归
    // 一颗树 如果左右子树高度一致，那么左子树必然是满的，左子树节点数=2^左子树高度-1 再递归去求右子树节点数 再+1 即为总数目
    // 一颗树 如果左右子树高度不一致，无法确认左子树有1个或者2个元素，但是倒数第二层右子树必然是满的，右子树节点数=2^右子树高度-1 再递归去求左子树节点数 再+1 即为总数目
    int dfs2(TreeNode root){
        if (root == null){
            return 0;
        }
        return dfs1(root.left) + dfs1(root.right) + 1;
    }


}
