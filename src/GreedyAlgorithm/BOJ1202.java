package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class jewel {
    int weight;
    int price;
    jewel (int weight, int price) {
        this.weight = weight;
        this.price = price;
    }
}

public class BOJ1202 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        jewel[] jewels = new jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i] = new jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        Arrays.sort(jewels, new Comparator<jewel>() {
            @Override
            public int compare(jewel o1, jewel o2) {
                if (o1.weight == o2.weight) {
                    return o2.price - o1.price;
                }
                return o1.weight - o2.weight;
            }
        });

        long result = 0;
        int num = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < K; i++) {
            while (num < N && jewels[num].weight <= bags[i]) {
                pq.offer(jewels[num].price);
                num++;
            }

            if (!pq.isEmpty()) {
               result += pq.poll();
            }
        }

        System.out.println(result);
    }
}
