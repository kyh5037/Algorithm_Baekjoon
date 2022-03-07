package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1439 {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer zeroSt = new StringTokenizer(str, "0");
        StringTokenizer oneSt = new StringTokenizer(str, "1");

        int zeroCount = zeroSt.countTokens();
        int oneCount = oneSt.countTokens();

        int result = Math.min(zeroCount, oneCount);
        System.out.println(result);
    }
}
