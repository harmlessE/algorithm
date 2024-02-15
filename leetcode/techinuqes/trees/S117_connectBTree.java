package leetcode.techinuqes.trees;

import leetcode.Node;
import leetcode.TreeNode;

import java.util.LinkedList;

public class S117_connectBTree {


    public LinkedList<Node> queue;
    public Node connect(Node root) {
        queue = new LinkedList<>();
        if(root ==null)
            return null;
        queue.offer(root);
        BFS(root);
        return root;
    }
    public void BFS(Node root){
        while (!queue.isEmpty()){

            int i = queue.size();
            Node cur = queue.poll();
            addInToQueue(cur);
            for (int j = 0; j < i; j++) {
                if(j==i-1){
                    cur.next = null;
                    break;
                }
                Node next = queue.poll();
                addInToQueue(next);
                cur.next = next;
                cur = next;
            }
        }
    }
    private void addInToQueue(Node cur) {
        if(cur.left!=null)
            queue.add(cur.left);
        if(cur.right!=null)
            queue.add(cur.right);
    }


}
