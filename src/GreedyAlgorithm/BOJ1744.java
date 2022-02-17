package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ1744 {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> posList = new ArrayList<>();
        ArrayList<Integer> negList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                posList.add(num);
            } else {
                negList.add(num);
            }
        }

        Collections.sort(posList, Collections.reverseOrder());
        int result = 0, i = 0;
        while (i < posList.size()) {
            if (i + 1 < posList.size() && posList.get(i) > 1 && posList.get(i + 1) > 1) {
                result += (posList.get(i) * posList.get(i + 1));
                i += 2;
            } else {
                result += posList.get(i);
                i++;
            }
        }

        Collections.sort(negList);
        int j = 0;
        while (j < negList.size()) {
            if (j + 1 < negList.size()) {
                result += (negList.get(j) * negList.get(j + 1));
                j += 2;
            } else {
                result += negList.get(j);
                j++;
            }
        }

        System.out.println(result);
    }
}
