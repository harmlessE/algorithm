## SORT

### quick sort

## bianry search

## Sliding Window

```
            int left = 0, right = 0;

            while(right < s.size()){
                window.add(s[right]);
                  
                while(window needs shrink){
                    window.remove(s[left]);
                    left++;
                }
            }
```





## DFS (back trace)

```
    private void dfs(List<Integer> ans, List<List<Integer>> res, int[] nums, boolean[] visited) {
        if(nums.length == ans.size()){
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
// 访问过的去除 剪枝
            if (visited[i])
                continue;
            visited[i] = true;
            ans.add(nums[i]);
            dfs(ans,res,nums,visited);
            visited[i] = false;
            ans.removeLast();
        }
    }
```
