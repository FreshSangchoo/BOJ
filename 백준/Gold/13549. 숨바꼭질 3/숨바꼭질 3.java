import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100001];
        int[] times = new int[100001];
        Arrays.fill(times, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{N, 0});
        times[N] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int loc = cur[0];
            int time = cur[1];
            visited[loc] = true;
            if (loc == K) break;
            if (0 <= (2 * loc) && (2 * loc) <= 100000 && !visited[2 * loc] && times[2 * loc] > time) {
                times[2 * loc] = time;
                pq.add(new int[]{2 * loc, time});
            }
            if (0 <= (loc - 1) && (loc - 1) <= 100000 && !visited[loc - 1] && times[loc - 1] > time + 1) {
                times[loc - 1] = time + 1;
                pq.offer(new int[]{loc - 1, time + 1});
            }
            if (0 <= (loc + 1) && (loc + 1) <= 100000 && !visited[loc + 1] && times[loc + 1] > time + 1) {
                times[loc + 1] = time + 1;
                pq.offer(new int[]{loc + 1, time + 1});
            }
        }
//        for (int i = 0; i < 100001; i++) if (times[i] != Integer.MAX_VALUE) System.out.println(i + ": " + times[i]);
        System.out.println(times[K]);
        br.close();
    }
}