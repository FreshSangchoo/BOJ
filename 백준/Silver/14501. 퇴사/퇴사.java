import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] counsel;
    static int max=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        counsel = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            counsel[i][0] = T;
            counsel[i][1] = P;
        }
        dfs(0, 0, 0);
        System.out.println(max);
        br.close();
    }
    static void dfs(int curIndex, int pay, int last){
        if(curIndex == N){
            max=Math.max(max,pay);
            return;
        }
        if(curIndex >= N){
            max=Math.max(max,pay-last);
            return;
        }
        for(int i=curIndex; i<N; i++){
            dfs(i+counsel[i][0], pay+counsel[i][1], counsel[i][1]);
        }
    }
}