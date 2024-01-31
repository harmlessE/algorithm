package leetcode.techinuqes;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class S347_topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());


        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(queue.size() < k){
                queue.offer(entry);
            }else{
                Map.Entry<Integer,Integer> currentMin = queue.peek();
                if(currentMin.getValue() <= entry.getValue()){
                    queue.poll();
                    queue.offer(entry);
                }
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k && !queue.isEmpty(); ++i){
            ans[i] = queue.poll().getKey();
        }
        return ans;
    }



}
