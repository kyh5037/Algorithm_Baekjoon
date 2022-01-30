package BOJ_단기간성장;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1655 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (i % 2 == 0) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if(maxHeap.peek() > minHeap.peek()) {
                    int temp = maxHeap.poll();
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(temp);
                }
            }

            sb.append(maxHeap.peek()).append('\n');
        }

        System.out.println(sb);
    }
}
