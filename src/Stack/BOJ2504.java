package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2504 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int num = 1, result = 0;
        boolean check = true;
        for (int i = 0; i < str.length(); i++) {
            char word = str.charAt(i);

            if (word == '(') {
                stack.push(word);
                num *= 2;
            } else if (word == '[') {
                stack.push(word);
                num *= 3;
            } else if (word == ')'){
                if(stack.isEmpty() || stack.peek() != '(') {
                    check = false;
                    break;
                }

                if (str.charAt(i - 1) == '(') {
                    result += num;
                }

                stack.pop();
                num /= 2;
            } else if (word == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    check = false;
                    break;
                }

                if (str.charAt(i - 1) == '[') {
                    result += num;
                }

                stack.pop();
                num /= 3;
            } else {
                check = false;
                break;
            }
        }

        if (!stack.isEmpty() || !check)
            System.out.println(0);
        else
            System.out.println(result);
    }
}
