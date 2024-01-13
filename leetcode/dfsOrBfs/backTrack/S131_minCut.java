package leetcode.dfsOrBfs.backTrack;

import java.util.ArrayList;
import java.util.List;

public class S131_minCut {


    List<List<String>> res = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {

        dfs(s,0);
        return res;

    }

    private void dfs(String s,int start) {

        if(start == s.length())
            res.add(new ArrayList<>(ans));

        for (int i = start; i < s.length(); i++) {
            // aabc 第一次进来 start = 0 i = 0 substring是左闭右开 应该是substring(0,1)
            // start = 0 继续往深走 选择a 找后面的[abc] 中的回文串 [a]
                // [abc] 中的回文串 start = 1, i = 1 时选择a 找[bc] 中的回文串 [a a]
                    // [bc] 中的回文串 start = 2, i = 2 选择b [a a b]
                        // start = 3 i = 3 选c [a a b c ] return
                    // [bc] 中的回文串 start = 2, i = 3 选择bc [a a bc] 剪枝
                // [abc] 中的回文串 start = 1, i = 2 时选择ab  [a ab] 剪枝
                // [abc] 中的回文串 start = 1, i = 3时选择ab  [a abc] 剪枝
            String temp = s.substring(start,i + 1);
            if(!isPalindrome(temp))
                break;
            ans.add(temp);
            dfs(s,i+1);
            ans.removeLast();
        }

    }

    public static boolean isPalindrome(String str) {
        // 去除空格并将字符串转换为小写（可根据需求调整）
        str = str.replaceAll("\\s", "").toLowerCase();

        int length = str.length();
        int mid = length / 2;

        for (int i = 0; i < mid; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
