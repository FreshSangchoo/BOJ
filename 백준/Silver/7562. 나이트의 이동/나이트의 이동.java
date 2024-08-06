import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        int[] di={-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dj={2, 1, -1, -2, -2, -1, 1, 2};

        for (int tc = 0; tc < T; tc++) {
            int I= Integer.parseInt(br.readLine());
            boolean[][] visited = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            int startI = Integer.parseInt(st.nextToken());
            int startJ = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endI = Integer.parseInt(st.nextToken());
            int endJ = Integer.parseInt(st.nextToken());

            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.add(new int[]{startI, startJ, 0});
            visited[startI][startJ] = true;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                if(cur[0] == endI && cur[1] == endJ) {
                    sb.append(cur[2]).append("\n");
                    break;
                }
                for(int d=0; d<8; d++){
                    int ni=cur[0]+di[d];
                    int nj=cur[1]+dj[d];
                    if(0<=ni&&ni<I && 0<=nj&&nj<I && !visited[ni][nj]){
                        q.offer(new int[]{ni,nj,cur[2]+1});
                        visited[ni][nj] = true;
                    }
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}