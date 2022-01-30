package BOJ_단기간성장;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2749 {
    public static long[] dp;

    /*  피사노 주기
     *  피보나치 수를 어떤 수 K로 나눌 때, 나머지는 항상 주기를 갖는다.
     */
    public static int NUM = 1000000;
    public static int PISANO = NUM / 10 * 15;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        n = n % PISANO;

        dp = new long[PISANO + 1];
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= PISANO; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % NUM;
        }

        System.out.println(dp[(int)n]);
    }
}
