import java.util.*;

class Solution {
    int[] di = {0, -1, 0, 1};
    int[] dj = {1, 0, -1, 0};
    int[][] landCopy;
    int[] pet;
    int chunkIdx = 2;
    int n, m;

    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        
        landCopy = new int[n][m];
        pet = new int[n * m + 2];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                landCopy[i][j] = land[i][j];
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(landCopy[i][j] == 1){
                    grouping(i, j);
                }
            }
        }
        
        int curCount = 0;
        int[] visited = new int[n * m + 2];
        
        for(int j=0; j<m; j++){
            curCount = 0;
            
            for(int i=0; i<n; i++){
                if(landCopy[i][j] != 0 && visited[landCopy[i][j]] != j){
                    curCount += pet[landCopy[i][j]];
                    visited[landCopy[i][j]] = j;
                }
            }
            
            answer = Math.max(answer, curCount);
        }
        
        return answer;
    }
    public void grouping(int i, int j){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{i, j});
        landCopy[i][j] = chunkIdx;
        pet[chunkIdx]++;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curi = cur[0];
            int curj = cur[1];
            
            for(int d=0; d<4; d++){
                int ni = curi + di[d];
                int nj = curj + dj[d];
                
                if(0<=ni&&ni<n && 0<=nj&&nj<m){
                    if(landCopy[ni][nj] == 1){
                        q.offer(new int[]{ni, nj});
                        landCopy[ni][nj] = chunkIdx;
                        pet[chunkIdx]++;
                    }
                        
                }
            }
            
        }
        
        chunkIdx++;
    }
}