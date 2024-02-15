package leetcode.techinuqes;

import java.util.Arrays;

public class S135_candy {
    public int candy(int[] ratings) {

        int[] candies = new int[ratings.length];

        candies[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            candies[i] = ratings[i] > ratings[i-1] ? candies[i-1] + 1 : 1;
        }

        for (int i = ratings.length-2; i > 0 ; i--) {
            if(ratings[i] > ratings[i + 1]){
                candies[i] = Math.max(candies[i],ratings[i + 1] + 1  );
            }
        }


        return Arrays.stream(candies).sum();

    }
}
