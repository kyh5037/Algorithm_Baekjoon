package DijkstraAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1504 {
    private static int N, E;
    private static ArrayList<Node>[] list;
    private static final int INF = 200000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int midStart = Integer.parseInt(st.nextToken());
        int midEnd = Integer.parseInt(st.nextToken());

        int result1 = 0;
        result1 += dijkstra(1, midStart);
        result1 += dijkstra(midStart, midEnd);
        result1 += dijkstra(midEnd, N);

        int result2 = 0;
        result2 += dijkstra(1, midEnd);
        result2 += dijkstra(midEnd, midStart);
        result2 += dijkstra(midStart, N);

        int answer = 0;
        if(result1 >= INF && result2 >= INF) answer = -1;
        else answer = Math.min(result1, result1);

        System.out.println(answer);
    }

    public static int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        boolean[] checked = new boolean[N + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (!checked[curNode.vertex]) {
                checked[curNode.vertex] = true;

                for (Node nextNode : list[curNode.vertex]) {
                    if (!checked[nextNode.vertex] && dist[nextNode.vertex] > dist[curNode.vertex] + nextNode.weight) {
                        dist[nextNode.vertex] = dist[curNode.vertex] + nextNode.weight;
                        pq.offer(new Node(nextNode.vertex, dist[nextNode.vertex]));
                    }
                }
            }
        }

        return dist[end];
    }
}
