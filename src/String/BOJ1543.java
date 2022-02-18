package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1543 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String str2 = br.readLine();

        int count = 0;
        str = str.replaceAll(str2, "0");
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') count++;
        }

        System.out.println(count);
    }
}
