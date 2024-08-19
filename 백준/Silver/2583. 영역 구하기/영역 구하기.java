import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] paper = new int[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    paper[k][j] = 1;
                }
            }
        }

//        for(int i=0; i<M; i++){
//            for(int j=0; j<N; j++){
//                System.out.print(paper[i][j]+" ");
//            }
//            System.out.println();
//        }

        int[] di = {0, -1, 0, 1};
        int[] dj = {1, 0, -1, 0};
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] || paper[i][j]==1) continue;
                q.offer(new int[]{i, j});
                visited[i][j] = true;
                int area = 0;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    area++;
                    for (int d = 0; d < 4; d++) {
                        int ni = cur[0] + di[d];
                        int nj = cur[1] + dj[d];
                        if (0 <= ni && ni < M && 0 <= nj && nj < N && !visited[ni][nj] && paper[ni][nj] == 0) {
                            q.offer(new int[]{ni, nj});
                            visited[ni][nj] = true;
                        }
                    }
                }
                pq.offer(area);
            }
        }
        sb.append(pq.size()).append("\n");
        while(!pq.isEmpty()) sb.append(pq.poll()).append(" ");
        System.out.println(sb);
        br.close();
    }
}