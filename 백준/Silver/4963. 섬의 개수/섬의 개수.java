import java.io.*;
import java.util.*;

public class Main {
    static int[] di={0, -1, -1 ,-1, 0, 1, 1, 1};
    static int[] dj={1, 1, 0, -1, -1, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        ArrayDeque<int[]> q=new ArrayDeque<>();
        while(true){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0) break;
            int[][] map = new int[h][w];
            boolean[][] visited=new boolean[h][w];

            for(int i=0; i<h; i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            int count=0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(visited[i][j]) continue;
                    if(map[i][j]==1){
                        count++;
                        visited[i][j] = true;
                        q.offer(new int[]{i, j});
                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            for (int d = 0; d < 8; d++) {
                                int ni = cur[0] + di[d];
                                int nj = cur[1] + dj[d];
                                if (0 <= ni && ni < h && 0 <= nj && nj < w && !visited[ni][nj] && map[ni][nj] == 1) {
                                    visited[ni][nj] = true;
                                    q.offer(new int[]{ni, nj});
                                }
                            }
                        }
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}