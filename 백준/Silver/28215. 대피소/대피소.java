import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[][] house;
    static boolean[] selected;
    static int max = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        house = new int[N][2];
        selected = new boolean[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            house[i][0] = x;
            house[i][1] = y;
        }

        comb(0, 0);

        System.out.println(max);
    }
    static void comb(int cnt, int r){
        if(cnt == K){
            calculate();
            return;
        }
        for(int i=r; i<N; i++){
            if(selected[i]) continue;
            selected[i] = true;
            comb(cnt+1, i+1);
            selected[i] = false;
        }
    }
    static void calculate(){
        int maxDist = 0;
        for(int i=0; i<N; i++){
            if(selected[i]) continue;
            int minDist = Integer.MAX_VALUE;

            for(int j=0; j<N; j++){
                // 대피소와의 거리 중 가까운 거리를 minDist에 저장
                if(selected[j]) {
                    int dist = Math.abs(house[i][0] - house[j][0]) + Math.abs(house[i][1] - house[j][1]);
                    minDist = minDist < dist ? minDist : dist;
                }
            }

            maxDist = maxDist > minDist ? maxDist : minDist;
            if(maxDist > max) return;
        }
        max = maxDist;
    }
}
