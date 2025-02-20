import java.util.*;
class Solution {
    static int N;
    static int maxDungeons = 0;
    static int[][] copy;
    static int[] sequence;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        copy = dungeons;
        sequence = new int[N];
        visited = new boolean[N];
        
        select(0, k);
        
        return maxDungeons;
    }
    static void select(int cnt, int stamina){
        if(cnt == N){
            maxDungeons = Math.max(maxDungeons, goDungeons(stamina));
            return;
        }
        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            sequence[cnt] = i;
            select(cnt+1, stamina);
            visited[i] = false;
        }
    }
    static int goDungeons(int stamina){
        int stam = stamina;
        int count = 0;
        for(int i=0; i<N; i++){
            if(copy[sequence[i]][0] <= stam){
                stam -= copy[sequence[i]][1];
                count++;
            }
        }
        return count;
    }
}