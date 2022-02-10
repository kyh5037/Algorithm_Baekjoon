package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ17413 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean check = false;
        for(int i = 0; i < str.length(); i++) {
            char word = str.charAt(i);
            if(word == '<') {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(word);
                check = true;
            } else if (word == '>') {
                sb.append(word);
                check = false;
            } else if (check) {
                sb.append(word);
            } else {
                if(word == ' ') {
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(word);
                } else {
                    stack.push(word);
                }
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
