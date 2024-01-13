package leetcode.dfsOrBfs.backTrack;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S17_letterCombinations {
    List<String> res = new ArrayList<>();
    StringBuilder ans = new StringBuilder();
    int index = 0;
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {

        if(digits.equals(""))
            return new ArrayList<>();


        dfs(digits.toCharArray());
        return res;
    }
    void dfs(char[] chars){
        if(ans.toString().length() == chars.length)
            res.add(new String(ans.toString()));
        if(index == chars.length)
            return;
        char[] options = phoneMap.get(chars[index]).toCharArray();
        for (int i = 0; i < options.length; i++) {
            ans.append(options[i]);
            index++;
            dfs(chars);
            index--;
            ans.deleteCharAt(ans.length() - 1);
        }
    }



}
