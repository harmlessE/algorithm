package leetcode.techinuqes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class S56_mergeIntervals {


    public static void main(String[] args) {
        int[][] twoDArray = {
                {1, 3},
                {15, 18},
                {2, 6},
                {8, 10},

        };

        int[] test = new int[128];

        test['C'] = 232;

//        System.out.println(test[24]);

        for (int i = 0; i < test.length; i++) {
            if(test[i] == 232)
                System.out.println(i);
        }




    }

     List<List<Integer>>  res = new ArrayList<>();

    public  int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing( arr ->
            arr[0]
        ));

        for (int i = 0; i < intervals.length; i++) {
            if(res.isEmpty()){
                res.add(IntStream.of(new int[]{intervals[i][0],intervals[i][1]}).boxed().collect(Collectors.toList()));
            }
            else if(res.getLast().getLast() >= intervals[i][0] ) {
                List<Integer> temp = res.getLast();
                res.removeLast();
                res.add(IntStream.of(new int[]{Math.min(intervals[i][0],temp.getFirst()),Math.max(intervals[i][1],temp.getLast())}).boxed().collect(Collectors.toList()));
            }else {
                res.add(IntStream.of(new int[]{intervals[i][0],intervals[i][1]}).boxed().collect(Collectors.toList()));
            }
//            res.add(Arrays.asList(Arrays.stream(new int[]{intervals[i-1][0],Math.max(intervals[i-1][1],intervals[i][1])}).boxed().toArray(Integer[]::new)));
        }


        return res.stream()
                .map(rowList -> rowList.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }







}
