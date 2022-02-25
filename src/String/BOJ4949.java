package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4949 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();

            if (".".equals(str)) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean check = true;
            for (int i = 0; i < str.length(); i++) {
                char word = str.charAt(i);

                if (word == '(' || word == '[') {
                    stack.push(word);
                } else if (word == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        check = false;
                        break;
                    }
                } else if (word == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        check = false;
                        break;
                    }
                }
            }

            sb.append(stack.isEmpty() && check == true ? "yes" : "no").append('\n');
        }

        System.out.println(sb);
    }
}
