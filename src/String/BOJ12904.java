package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ12904 {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer S = new StringBuffer(br.readLine());
        StringBuffer T = new StringBuffer(br.readLine());

        while (S.length() < T.length()) {
            if (T.charAt(T.length() - 1) == 'A') {
                T.deleteCharAt(T.length() - 1);
            } else if (T.charAt(T.length() - 1) == 'B') {
                T.deleteCharAt(T.length() - 1);
                T.reverse();
            }
        }

        if (S.toString().equals(T.toString())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
