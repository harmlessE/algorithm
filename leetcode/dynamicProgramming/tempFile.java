package leetcode.dynamicProgramming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class tempFile {
    //BFS 先序


    public boolean canFinish(int numCourses, int[][] prerequisites) {




        int[] indegrees = new int[numCourses]; // 入度
        List<List<Integer>> adjacency = new ArrayList<>(); // 邻接节点
        for (int i=0;i<numCourses;i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
            // 邻接表 对每个课程 加入 课程的前置课程List
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>(); // 存放当前可学课程，即：入度为0的课程
        for (int i=0;i<numCourses;i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        // 只要有课程可以学，就开始学
        while (!queue.isEmpty()) {
            // poll一个课程，就是学习一个课程
            Integer poll = queue.poll();
            // 学完一个课程，待学习的课程数减1
            numCourses--;
            // 学完该课程，需要把其邻接课程的入度减1
            for (Integer ad : adjacency.get(poll)) {
                indegrees[ad]--;
                // 邻接课程ad的入度更新后，需要判断是否为0，若为0，证明课程ad也可以学习了，需要加到可学课程队列中
                if (indegrees[ad] == 0) {
                    queue.add(ad);
                }
            }
        }
        // 到这一步，queue为空（即没有可学课程了），此时判断待学习课程数numCourses是否为0，若为0，全部课程学习结束
        return numCourses == 0;
    }

}
