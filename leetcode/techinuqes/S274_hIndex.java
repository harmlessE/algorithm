package leetcode.techinuqes;

import java.util.Arrays;

public class S274_hIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        int h = n;
        while(h > 0){
            if(citations[n-h] >= h) return h;
            h--;
        }
        return 0;
        // 下标为n-h的论文的引用次数，因为这篇论文后面（包括它自己）的数量为h，如果这篇论文的引用次数小于h，说明这个h是不满足条件的，反之则直接返回。
    }



}
