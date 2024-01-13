package newCoder;

import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class acm_template {


    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int row = in.nextInt();
        int column = in.nextInt();
        int maxMove = 0;
        char[][] matrix = new char[row][column];
        String sen = in.nextLine();
        System.out.println(sen);
        System.out.println(Arrays.toString(matrix));
    }

    public static void main3(String args[]){
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        for (int i = 0; i < rows; i++) {
            int n = in.nextInt();
            int sum = 0;
            for(int j=0;j < n;j++){
                sum += in.nextInt();
            }
            System.out.println(sum);
        }
    }

    public static void main6(String args[]){
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            int n = in.nextInt();
            int sum = 0;
            for(int j=0;j < n;j++){
                sum += in.nextInt();
            }
            System.out.println(sum);
            in.nextLine();
        }
    }

    public static void main7(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String[] str = sc.nextLine().split(" ");
            int sum=0;
            for(int i=0;i<=str.length-1;i++){
                sum = sum+Integer.valueOf(str[i]);
            }
            System.out.println(sum);
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int nums = in.nextInt();

            int[] arr = new int[nums];
            int[] path = new int[nums];

            if(nums == 0 || nums == 1){
                System.out.println(nums);
                break;
            }
            path[0] = 1;

            for (int i = 0; i < nums; i++) {
                arr[i] = in.nextInt();
            }
            int max = 1;
            for (int i = 1; i < nums; i++) {
                if(arr[i] - arr[i-1] < 9){
                    path[i] = path[i-1] + 1;
                }else{
                    path[i] = 1;
                }
            }
            for (int i = 0; i < path.length; i++) {
                max = Math.max(path[i],max);
            }
            System.out.println(max);
        }
    }

    //kanan唱歌经常高音上不去，为此她非常苦恼。
    //后来她发现了一个规律，一段连续的音符，只要后一个音比前一个音的高度差不大于8那么她就能唱上去。
    //但如果一个音过高，比前一个音高9以上，kanan就无法发出这个音了。
    //而低音则没有这个限制。如“1 5 10 1 2”她就能完整唱完，但“1 10 5 1 2”她就不能完整唱完。
    //现在有一段音符。她想截取其中一个连续的片段把它唱完。她想知道，这个片段长度的最大值是多少？ 55 66 1 88 1
    public static void mai3n(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=in.nextInt();
        int count=0,max=0;
        for(int i=1;i<n;i++) {
            if(a[i]-a[i-1]<=8) {
                count++;
                if(count>max)max=count;
            }
            else count=0;
        }
        System.out.println(max+1);

    }

    //游游有
    //n个苹果，
    //m个桃子。她可以把2个苹果和1个桃子组成价值
    //a元的一号水果大礼包，也可以把1个苹果和2个桃子组成价值
    //b元的二号水果大礼包。游游想知道，自己最多能组成多少价值总和的大礼包？
    //输入描述:
    //n,m,a,b，用空格隔开。分别代表苹果的数量、桃子的数量、一号大礼包价值、二号大礼包价值。
    public static void main8(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int numsOfApple = in.nextInt();
            int numsOfPeach = in.nextInt();
            int valueOfOne = in.nextInt();
            int valueOfTwo = in.nextInt();

            if(numsOfPeach <= 1 && numsOfApple <=1){
                System.out.println(0);
                break;
            }

            long maxSum = 0;

            // peach 选1...numsOfPeach 个数  pingguo taozi [3,4,1,2]

            // 可能有0....桃子个数个 遍历 使用 每种桃子个数产生的价值
            // 如果是 8个桃子 可能和16个苹果去匹配价值 也可能和4个苹果去匹配， 也可能和4个用来匹配8个苹果，4个用来匹配2个苹果
            for (int i = 0; i <= numsOfPeach; i++) {
                if(2 * i > numsOfApple)
                    continue;

                // 定下来了 买i个 一号礼包
                long w1 = (long) i * valueOfOne;
//                int left = Math.min((n - i * 2), (m - i)/2);
                // 剩下的 numsOfPeach - i 个桃子买二号 买二号的数量 不仅由桃子数量决定 还由剩下的苹果数量决定 能买几个二号礼包
                int left = Math.min((numsOfPeach - i)  / 2, (numsOfApple - 2 * i) );
                long w2 = (long) left * valueOfTwo ;
                if(w2 < 0)
                    w2 = 0;

                maxSum = Math.max(maxSum,w1+w2);

            }
            System.out.println(maxSum);
        }
    }






    public static void main225(String[] args) {

        Scanner in = new Scanner(System.in);
//        System.out.println(getCountTwoPointers("abcba"));


        int rows = in.nextInt();
        in.nextLine();

        for (int i = 0; i < rows ; i++) {
            String a = in.next();
            String b = in.next();

            int countA = 0;

            for (int j = 0; j <= a.length(); j++) {
                for (int k = j; k <= a.length(); k++) {
                    countA = Math.max(getCountTwoPointers(a.substring(j,k)),countA);
                }
            }
            int countB = 0;

            for (int j = 0; j <= b.length(); j++) {
                for (int k = j; k <= b.length(); k++) {
                    countB = Math.max(getCountTwoPointers(b.substring(j,k)),countB);
                }
            }

            System.out.println(countA + countB);
        }
    }

    private static int getCountTwoPointers(String a){
        int l = 0;
        int r = a.length() - 1;

        int countA = 0;

        while (l < r){
            if(a.charAt(l) == a.charAt(r)){
                l++;
                r--;
                countA = countA + 2;
            }else {
                return 0;
            }
        }
        if(a.length()%2 == 1)
            countA++;

        return countA;
    }

    private static int getCount(String a){
        int[] letterArr = new int[25];
        Arrays.fill(letterArr, 0);
        for (int j = 0; j < a.length(); j++) {
            int index = a.charAt(j)  - 'a';
            letterArr[index] ++;
        }
        int countA = 0;
        int oneSA = 0;
        for (int j = 0; j <  letterArr.length; j++) {
            if (letterArr[j] % 2 == 0) {
                countA += (letterArr[j] / 2) * 2;
            }
            letterArr[j] = letterArr[j] % 2;
            if (letterArr[j] == 1)
                oneSA++;
        }
        if (oneSA >= 1 && countA % 2 == 1)
            countA++;
        return countA;
    }























}