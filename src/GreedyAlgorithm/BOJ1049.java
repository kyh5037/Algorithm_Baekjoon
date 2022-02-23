package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1049 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minPack = Integer.MAX_VALUE, minInd = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pack = Integer.parseInt(st.nextToken());
            int ind = Integer.parseInt(st.nextToken());

            minPack = Math.min(minPack, pack);
            minInd = Math.min(minInd, ind);
        }

        int result = 0;
        while (N > 0) {
            if (N >= 6) {
                if (minPack <= (6 * minInd)) {
                    result += minPack;
                } else {
                    result += (6 * minInd);
                }

                N -= 6;
            } else {
                if (minPack <= (N * minInd)) {
                    result += minPack;
                } else {
                    result += (N * minInd);
                }

                break;
            }
        }

        System.out.println(result);
    }
}
