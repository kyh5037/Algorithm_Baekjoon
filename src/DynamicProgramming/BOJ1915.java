package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1915 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                dp[i][j] = str.charAt(j - 1) - '0';
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == 1) {
                    int left = dp[i][j - 1];
                    int top = dp[i - 1][j];
                    int diagnol = dp[i - 1][j - 1];

                    dp[i][j] = Math.min(left, Math.min(top, diagnol)) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        int result = max * max;
        System.out.println(result);
    }
}
