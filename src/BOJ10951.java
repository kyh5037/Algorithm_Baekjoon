import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10951 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while ((str = br.readLine()) != null) {
            st = new StringTokenizer(str, " ");

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            sb.append(num1 + num2).append('\n');
        }

        System.out.println(sb);
    }
}
