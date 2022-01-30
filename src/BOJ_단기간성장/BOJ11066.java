package BOJ_단기간성장;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11066 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testcase; i++) {
            int K = Integer.parseInt(br.readLine());
            int[] files = new int[K];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                files[j] = Integer.parseInt(st.nextToken());
            }

            int[] sum = new int[K];
            sum[0] = files[0];
            for (int j = 1; j < K; j++) {
                sum[j] = sum[j - 1] + files[j];
            }

            int result = sumFile(files, sum);
            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }

    public static int sumFile(int[] files, int[] sum) {
        int[][] dp = new int[files.length][files.length];

        for (int i = 0; i < dp.length - 1; i++) {
            dp[i][i + 1] = files[i] + files[i + 1];
        }

        for (int j = 2; j < dp.length; j++) {
            for (int i = 0; i + j < dp.length; i++) {
                for (int k = i; k < i + j; k++) {
                    if (dp[i][i + j] == 0) {
                        dp[i][i + j] = dp[i][k] + dp[k + 1][i + j] + sumDist(sum, i, i + j);
                    } else {
                        dp[i][i + j] = Math.min(dp[i][i + j], dp[i][k] + dp[k + 1][i + j] + sumDist(sum, i, i + j));
                    }
                }
            }
        }

        return dp[0][dp.length - 1];
    }

    public static int sumDist(int[] sum, int i, int j) {
        if (i == 0) {
            return sum[j];
        }
        return sum[j] - sum[i - 1];
    }
}
