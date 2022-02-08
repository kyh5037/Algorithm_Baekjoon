package DijkstraAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class airport implements Comparable<airport> {
    int vertex;
    int cost;
    int weight;
    airport(int vertex, int cost, int weight) {
        this.vertex = vertex;
        this.cost = cost;
        this.weight = weight;
    }

    @Override
    public int compareTo(airport o) {
        return weight - o.weight;
    }
}

public class BOJ10217 {
    private static BufferedReader br;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < testcase; i++) {
            sb.append(exeMethod());
        }

        System.out.println(sb);
    }

    public static String exeMethod() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<airport> list[] = new ArrayList[N + 1];
        int[][] dist = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 출발지
            int v = Integer.parseInt(st.nextToken()); // 도착지
            int c = Integer.parseInt(st.nextToken()); // 소요시간
            int d = Integer.parseInt(st.nextToken()); // 비용
            list[u].add(new airport(v, c, d));
        }

        PriorityQueue<airport> pq = new PriorityQueue<>();
        pq.offer(new airport(1, 0, 0));
        dist[1][0] = 0;

        int result = Integer.MAX_VALUE;
        while(!pq.isEmpty()) {
            airport curAirport = pq.poll();

            if(curAirport.vertex == N) {
                result = Math.min(result, curAirport.weight);
                break;
            }

            for(airport nextAirport : list[curAirport.vertex]) {
                if(curAirport.cost + nextAirport.cost > M) {
                    continue;
                }

                if(dist[nextAirport.vertex][curAirport.cost + nextAirport.cost] > curAirport.weight + nextAirport.weight) {
                    dist[nextAirport.vertex][curAirport.cost + nextAirport.cost] = curAirport.weight + nextAirport.weight;

                    pq.offer(new airport(nextAirport.vertex, curAirport.cost + nextAirport.cost, curAirport.weight + nextAirport.weight));
                }
            }
        }

        if(result == Integer.MAX_VALUE) {
            return "Poor KCM\n";
        } else {
            return result + "\n";
        }
    }
}
