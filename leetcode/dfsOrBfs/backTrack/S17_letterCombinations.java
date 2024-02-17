package leetcode.dfsOrBfs.backTrack;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S17_letterCombinations {


    //
//    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
//    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//
//
//    示例 1：
//
//    输入：digits = "23"
//    输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//    示例 2：
//
//    输入：digits = ""
//    输出：[]
//    示例 3：
//
//    输入：digits = "2"
//    输出：["a","b","c"]

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
