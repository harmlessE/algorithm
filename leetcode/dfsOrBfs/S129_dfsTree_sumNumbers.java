package leetcode.dfsOrBfs;

import leetcode.TreeNode;

import java.util.ArrayList;

public class S129_dfsTree_sumNumbers {
    String path = "";
    ArrayList<String> res = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root);

        int result = res.stream()
                .mapToInt(Integer::parseInt)  // 将字符串转换为整数
                .sum();
        return result;
    }
    public void dfs (TreeNode root){
        if(root == null){
            return;
        }
        path += String.valueOf(root.val);
        if(root.left == null && root.right == null)
            res.add(path);
        dfs(root.left);
        dfs(root.right);
        path = path.substring(0,path.length()-1);
    }

}
