package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bombStr = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if (stack.size() >= bombStr.length()) {
                boolean flag = true;

                for (int j = 0; j < bombStr.length(); j++) {
                    if (stack.elementAt(stack.size() - bombStr.length() + j) != bombStr.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < bombStr.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (stack.size() != 0) {
            for (char c : stack) {
                sb.append(c);
            }
        } else {
            sb.append("FRULA");
        }

        sb.append('\n');
        System.out.println(sb);
    }
}
