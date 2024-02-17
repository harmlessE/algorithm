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
## BFS (Graph)

```
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> lookup = new HashMap<>();
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        Deque<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            for (Node n : tmp.neighbors) {
                if (!lookup.containsKey(n)) {
                    lookup.put(n, new Node(n.val, new ArrayList<>()));
                    queue.offer(n);
                }
                lookup.get(tmp).neighbors.add(lookup.get(n));
            }
        }
        return clone;
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

## Graph 
### 岛屿问题的通用解法

```
void dfs(int[][] grid, int r, int c) {
    // 判断 base case
    if (!inArea(grid, r, c)) {
        return;
    }
    // 如果这个格子不是岛屿，直接返回
    if (grid[r][c] != 1) {
        return;
    }
    grid[r][c] = 2; // 将格子标记为「已遍历过」
    
    // 访问上、下、左、右四个相邻结点
    dfs(grid, r - 1, c);
    dfs(grid, r + 1, c);
    dfs(grid, r, c - 1);
    dfs(grid, r, c + 1);
}

// 判断坐标 (r, c) 是否在网格中
boolean inArea(int[][] grid, int r, int c) {
    return 0 <= r && r < grid.length 
        	&& 0 <= c && c < grid[0].length;
}
```


