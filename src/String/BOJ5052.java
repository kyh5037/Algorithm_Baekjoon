package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ5052 {
    private static BufferedReader br;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < testcase; i++) {
            boolean result = exemethod();

            if(result == true) {
                sb.append("YES").append('\n');
            } else {
                sb.append("NO").append('\n');
            }
        }

        System.out.println(sb);
    }

    public static boolean exemethod() throws Exception {
        int n = Integer.parseInt(br.readLine());
        String[] strArr = new String[n];

        for(int i = 0; i < n; i++) {
            strArr[i] = br.readLine();
        }
        Arrays.sort(strArr);

        boolean result = true;
        for(int i = 1; i < strArr.length; i++) {
            if(strArr[i].startsWith(strArr[i - 1])) {
                result = false;
                break;
            }
        }

        return result;
    }
}
