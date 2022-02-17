package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1783 {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = 0;
        if (N == 1) {
            result = 1;
        } else if (N == 2) {
            result = Math.min(4, (M + 1) / 2);
        } else if (N >= 3){
            if (M < 7) {
                result = Math.min(4, M);
            } else {
                result = M - 2;
            }
        }

        System.out.println(result);
    }
}
