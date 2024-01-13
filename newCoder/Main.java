package newCoder;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        String[] time = input.split(":");
        String[] operation = new String[2];
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            operation[0] = sc.next();
            operation[1] = String.valueOf(sc.nextInt());


            if(operation[0].equals("+")){

                int moreMin = Integer.parseInt(operation[1]) + Integer.parseInt(time[1]);
                int moreHour = moreMin / 60;
                int minLeft = moreMin % 60;
                if(moreMin >= 60){
                    time[0] = String.valueOf((Integer.parseInt(time[0]) + moreHour) % 24);
                    time[1] = String.valueOf(minLeft);
                }else{
                    time[1] = String.valueOf(moreMin);
                }
            } else if (operation[0].equals("-")) {

                int lessMin = Integer.parseInt(time[1]) - Integer.parseInt(operation[1]);

                if(lessMin < 0){
                    int lessHour = Integer.parseInt(operation[1]) / 60;
                    time[0] = String.valueOf( 24 - lessHour - 1);
                    time[1] = String.valueOf( 60 + (lessMin % 60) );
                }else{
                    time[1] = String.valueOf(lessMin);
                }
            }
            if(time[0].length() == 1){
                time[0] = '0' + time[0];
            }
            if(time[1].length() == 1){
                time[1] = '0' + time[1];
            }
        }

        String res = String.join(":", time);
        System.out.println(res);
    }
}