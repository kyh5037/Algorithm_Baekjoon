package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ5397 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String str = br.readLine();

            Stack<Character> lStack = new Stack<>();
            Stack<Character> rStack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == '<') {
                    if (!lStack.isEmpty()) {
                        rStack.push(lStack.pop());
                    }
                } else if (c == '>') {
                    if (!rStack.isEmpty()) {
                        lStack.push(rStack.pop());
                    }
                } else if (c == '-') {
                    if (!lStack.isEmpty()) {
                        lStack.pop();
                    }
                } else {
                    lStack.push(c);
                }
            }

            while (!lStack.isEmpty()) {
                rStack.push(lStack.pop());
            }

            while (!rStack.isEmpty()) {
                sb.append(rStack.pop());
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}
