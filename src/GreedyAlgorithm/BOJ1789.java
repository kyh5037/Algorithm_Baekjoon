package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1789 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long num = 1;
        while (true) {
            if ( S - num >= 0) {
                S -= num;
                num++;
            } else {
                break;
            }
        }

        System.out.println(num - 1);
    }
}
