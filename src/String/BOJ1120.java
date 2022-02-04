package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1120 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str1 = st.nextToken();
        String str2 = st.nextToken();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= str2.length() - str1.length(); i++) {
            int count = 0;
            for (int j = 0; j < str1.length(); j++) {
                if (str1.charAt(j) != str2.charAt(i + j))
                    count++;
                if (count > min)
                    break;
            }
            min = Math.min(min, count);
        }

        System.out.println(min);
    }
}
