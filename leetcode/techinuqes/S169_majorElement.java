package leetcode.techinuqes;

import java.util.HashMap;
import java.util.Map;

public class S169_majorElement {

    // 找众数并且众数一定大于n/2


    // 方法一 摩尔投票法
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums){
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }

    // 方法二 哈希表法
    public int majorityElementHash(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for (int num : nums){
            map.compute(num,(k,v) ->
                (v == null) ? 1 : v + 1
            );
        }
        int maxCount = 0;
        int res = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                res = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return res;
    }


}
