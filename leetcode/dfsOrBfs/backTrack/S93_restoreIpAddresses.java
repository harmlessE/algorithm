package leetcode.dfsOrBfs.backTrack;

import java.util.ArrayList;
import java.util.List;

public class S93_restoreIpAddresses {
    List<String> res = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {

        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int start) {
        if(ans.size() >= 4)
            res.add(String.join("."));

        for (int i = start; i < s.length(); i++) {
            String temp = s.substring(start,i);
            if(Integer.parseInt(temp) > 255)
                break;
            ans.add(temp);
            dfs(s,i+1);
            ans.removeLast();
        }

    }
}
