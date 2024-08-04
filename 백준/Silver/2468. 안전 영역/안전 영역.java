import java.io.*;
import java.util.*;

public class Main {
    static int[] di = {0, -1, 0, 1};
    static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        int maxH = 0;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, map[i][j]);
            }
        }
        int maxArea = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int h = 0; h < maxH; h++) {
            int area = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (h % 2 == 0) {
                        if (visited[i][j]) continue;
                        if(map[i][j]<=h) continue;
                        visited[i][j] = true;
                        q.offer(new int[]{i, j});
                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            for (int d = 0; d < 4; d++) {
                                int ni = cur[0] + di[d];
                                int nj = cur[1] + dj[d];
                                if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj] && map[ni][nj] > h) {
                                    q.offer(new int[]{ni, nj});
                                    visited[ni][nj] = true;
                                }
                            }
                        }
                        area++;
                    } else {
                        if (!visited[i][j]) continue;
                        if(map[i][j]<=h) continue;
                        visited[i][j] = false;
                        q.offer(new int[]{i, j});
                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            for (int d = 0; d < 4; d++) {
                                int ni = cur[0] + di[d];
                                int nj = cur[1] + dj[d];
                                if (0 <= ni && ni < N && 0 <= nj && nj < N && visited[ni][nj] && map[ni][nj] > h) {
                                    q.offer(new int[]{ni, nj});
                                    visited[ni][nj] = false;
                                }
                            }
                        }
                        area++;
                    }
                }
            }
//            System.out.println(h+"일 때 "+area);
            maxArea = Math.max(maxArea, area);
        }
        System.out.println(maxArea);
        br.close();
    }
}