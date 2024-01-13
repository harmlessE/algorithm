package leetcode.dfsOrBfs;

import java.util.*;

public class S207_classTimeTables {


    public static void main(String[] args) {
        System.out.println(canFinish(2,new int[][]{{1, 0}}));;
    }
    //BFS 先序
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        HashMap<Integer,List<Integer>> adjency = new HashMap<>();

        for (int i=0;i<numCourses;i++) {
            adjency.put(i,new ArrayList<>());
        }
        for(int[] prerequisite:prerequisites){
            // 需要后一个课程作为前一个课程的前置课程
            // 此课程入度+1
            inDegrees[prerequisite[0]] ++ ;
            // 构建邻接表 用于出队的时候优化
            // 对于邻接表中的每个元素，出队的时候，要去找他们指向的元素，去减少对应的元素的入度
            List<Integer> intList = adjency.get(prerequisite[1]);
            intList.add(prerequisite[0]);
            adjency.put(prerequisite[1], intList);
        }
        Queue<Integer> queue = new LinkedList<>();

        // 初始化queue 用入度为0的元素先入队
        for (int i = 0; i < inDegrees.length; i++) {
            if(inDegrees[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            //队列里的是入度为0的课 可以直接上
            int courseNum =  queue.poll();
            numCourses--;
            //查找邻接表 去减少相应的课程的入度
            System.out.println(courseNum);
            List<Integer> adjNodes = adjency.get(courseNum);
            if(adjNodes.isEmpty())
                continue;
            for(Integer temp:adjNodes){
                inDegrees[temp] --;
                if(inDegrees[temp] == 0)
                    queue.offer(temp);
            }

        }
        return numCourses == 0;
    }


    //DFS 深度搜索 用memo优化 判断环：当path中存在两个相同的节点时 那么就是环
    boolean[] path;
    boolean[] memo;
    boolean cycle;
    List<Integer> topo;
    Map<Integer, List<Integer>> graph;

    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        graph = new HashMap<>();

        // 根据前置课程 生成邻接表
        for (int[] edge : prerequisites) {
            int x = edge[0];
            int y = edge[1];
            if (!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
            }
            graph.get(y).add(x);
        }
        path = new boolean[numCourses];
        memo = new boolean[numCourses];
        cycle = false;
        for (int i = 0; i < numCourses; i++) {
            if (!memo[i]) {
                dfs(i);
            }
        }
        return !cycle;
    }
    void dfs(int x) {
        if (cycle) {
            return;
        }
        // 栈中存在两个相同点 有环路 不可能完成课程表
        if (path[x]) {
            cycle = true;
            return;
        }
        // dfs(x) 已经完成 不用在做一次
        if (memo[x]) {
            return;
        }

        // BFS 有初始节点（入度==0） 但是DFS需要遍历对每个节点 如果是被指向的节点 等于就是不处理
        // 如果是指向他人的节点 那么就去做DFS 对每一个节点DFS判断是否存在环 存在环则课程表不可能
        path[x] = true;

        if(graph.containsKey(x))
            for (int y : graph.get(x)) {
                dfs(y);
            }

        // 通过回溯做空间优化
        path[x] = false;

        // 代表 visited 做缓存 不然就会超时
        memo[x] = true;
    }

}
