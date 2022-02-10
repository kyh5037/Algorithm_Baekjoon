package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ16916 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String P = br.readLine();

        if (S.contains(P)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
