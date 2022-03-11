package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1080 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] start = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                start[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        int[][] end = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                end[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        int result = 0;
        if (N >= 3 && M >= 3) {
            for (int i = 0; i <= N - 3; i++) {
                for (int j = 0; j <= M - 3; j++) {
                    if (start[i][j] != end[i][j]) {
                        result++;
                        for (int x = i; x < i + 3; x++) {
                            for (int y = j; y < j + 3; y++) {
                                start[x][y] = start[x][y] == 1 ? 0 : 1;
                            }
                        }
                    }
                }
            }
        }

        boolean check = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (start[i][j] != end[i][j]) {
                    check = false;
                    break;
                }
            }
        }

        System.out.println(check ? result : -1);
    }
}
