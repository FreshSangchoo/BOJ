import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] rel = new int[n][n];
        boolean[] visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            rel[x][y] = 1;
            rel[y][x] = 1;
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{a, 0});
        int ans=-1;
        while (!q.isEmpty()) {
            int[] re = q.poll();
            int x = re[0];
            for (int i = 0; i < n; i++) {
                if (!visited[i] && rel[x][i] == 1) {
                    if(i==b) {
                        ans=re[1]+1;
                        break;
                    }
                    q.offer(new int[]{i, re[1] + 1});
                    visited[i] = true;
                }
            }
        }
        System.out.println(ans);
        br.close();
    }
}