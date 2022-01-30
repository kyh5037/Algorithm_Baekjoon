package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1003 {

    public static int countZero;
    public static int countOne;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testcase; i++) {
            int N = Integer.parseInt(br.readLine());
            countZero = 0; countOne = 0;

            Fibonacci(N);
            sb.append(countZero).append(' ').append(countOne).append('\n');
        }

        System.out.println(sb);
    }

    public static void Fibonacci(int num) {
        int first_num = 0; int second_num = 1;
        int dp = 0;

        if (num == 0) {
            countZero++;
            return;
        } else if (num == 1) {
            countOne++;
            return;
        } else {
            for (int i = 1; i < num; i++) {
                dp = first_num + second_num;
                first_num = second_num;
                second_num = dp;
            }

            countZero = first_num;
            countOne = second_num;
        }


    }
}
