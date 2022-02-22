package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1715 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while (pq.size() > 1) {
            int num = pq.poll();
            int num2 = pq.poll();

            int temp = num + num2;
            result += temp;
            pq.offer(temp);
        }

        System.out.println(result);
    }
}
