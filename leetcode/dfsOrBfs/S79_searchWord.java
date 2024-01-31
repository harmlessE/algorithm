package leetcode.dfsOrBfs;


import java.lang.reflect.Array;
import java.util.Arrays;

class S79_searchWord{


    StringBuilder builder = new StringBuilder();

    boolean flag = false;


    boolean[][] visited;


    public boolean exist(char[][] board, String word) {

        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board,word,i,j,0);
            }
        }


        return flag;
    }


    public void dfs(char[][] board, String word,int i, int j, int depth) {
        if(builder.toString().contains(word)){
            flag = true;
            return;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;

        if(visited[i][j])
            return;
        //还可以有一个剪枝的方法 如果当前字符串位数不等于 board i j 就不用往下去搜了
        if(word.charAt(depth) != board[i][j])
            return;
        visited[i][j] = true;
        builder.append(board[i][j]);
        dfs(board,word,i + 1 , j,depth + 1);
        dfs(board,word,i - 1 , j , depth + 1);
        dfs(board,word,i , j + 1,depth + 1);
        dfs(board,word,i , j - 1, depth + 1);
        visited[i][j] = false;
        builder.deleteCharAt(builder.length()-1);
    }


}