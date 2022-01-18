package BOJ_단기간성장;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10830 {

    public static int N;
    public static final int NUM = 1000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int[][] result = new int[N][N];
        int[][] divide = new int[N][N];

        long B = Long.parseLong(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                divide[i][j] = Integer.parseInt(st.nextToken());
            }
            result[i][i] = 1;
        }

        while(B > 0) {

            if(B % 2 == 1) {
                result = squared(result, divide);
            }

            divide = squared(divide, divide);

            B /= 2;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static int[][] squared(int[][] arr1, int[][] arr2) {

        int[][] ret = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    ret[i][j] += arr1[i][k] * arr2[k][j];
                }
                ret[i][j] %= NUM;
            }
        }

        return ret;
    }
}
