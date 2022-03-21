package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ11656 {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String temp = "";
        List<String> list = new ArrayList<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            temp += str.charAt(i);
            StringBuffer sb = new StringBuffer(temp);
            list.add(sb.reverse().toString());
        }

        Collections.sort(list);
        for (String result : list) {
            System.out.println(result);
        }
    }
}
