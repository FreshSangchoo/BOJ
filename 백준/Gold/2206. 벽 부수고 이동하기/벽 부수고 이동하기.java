import java.io.*;
import java.util.*;

public class Main {
    static int[] di={0, -1, 0, 1};
    static int[] dj={1, 0, -1, 0};
    static int N, M, min=Integer.MAX_VALUE;
    static int[][] map;
    static boolean isEnd=false;
    static boolean[][][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        // dfs(0, 0, 1, true);
        bfs(0, 0);
        if(isEnd) System.out.println(min);
        else System.out.println(-1);
        br.close();
    }
    static void bfs(int i, int j){
        ArrayDeque<int[]> q=new ArrayDeque<>();
        q.offer(new int[]{i, j, 1, 1});
        visited[i][j][0]=true;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            if(cur[0]==N-1 && cur[1]==M-1){
                isEnd=true;
                min=Math.min(min,cur[2]);
                return;
            }
            for(int d=0; d<4; d++){
                int ni=cur[0]+di[d];
                int nj=cur[1]+dj[d];
                if(0<=ni && ni<N && 0<=nj && nj<M){
                    if(cur[3]==1 && !visited[ni][nj][0]){
                        if (map[ni][nj] == 0) {
                            visited[ni][nj][0] = true;
                            q.offer(new int[]{ni, nj, cur[2] + 1, cur[3]});
                            //System.out.println(ni+" "+nj+" 여기 갈거야 "+(cur[2]+1)+" "+cur[3]);
                        } else if (map[ni][nj] == 1) {
                            visited[ni][nj][1] = true;
                            q.offer(new int[]{ni, nj, cur[2] + 1, 0});
                            //System.out.println(ni+" "+nj+" 여기 갈거야 "+(cur[2]+1)+" "+cur[3]);
                        }
                    } else if(cur[3]==0 && !visited[ni][nj][1]){
                        if (map[ni][nj] == 0) {
                            visited[ni][nj][1] = true;
                            q.offer(new int[]{ni, nj, cur[2] + 1, cur[3]});
                            //System.out.println(ni+" "+nj+" 여기 갈거야 "+(cur[2]+1)+" "+cur[3]);
                        }
                    }
                }
            }
        }
    }
//    static void dfs(int i, int j, int dist, boolean canBreak) {
//        if(dist>min) return;
//        if(i==N-1 && j==M-1) {
//            min=Math.min(min,dist);
//            isEnd=true;
//            return;
//        }
//        visited[i][j] = true;
//        //System.out.println(i+", "+j+" 에 왔어. "+canBreak);
//        for(int d = 0; d < 4; d++) {
//            int ni=i+di[d];
//            int nj=j+dj[d];
//            if(0<=ni && ni<N && 0<=nj && nj<M && !visited[ni][nj]) {
//                if(map[ni][nj]==0){
//                    dfs(ni,nj,dist+1, canBreak);
//                    visited[ni][nj]=false;
//                } else if(map[ni][nj]==1 && canBreak){
//                    canBreak=false;
//                    dfs(ni,nj,dist+1, canBreak);
//                    canBreak=true;
//                    visited[ni][nj]=false;
//                }
//            }
//        }
//
//    }
}