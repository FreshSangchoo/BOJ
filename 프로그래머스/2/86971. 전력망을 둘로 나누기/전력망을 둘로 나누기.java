import java.util.*;
class Solution {
    static int[][] graph;
    static int answer=Integer.MAX_VALUE;
    static int[] tops;
    public int solution(int n, int[][] wires) {
        graph = new int[n][n];
        
        for(int i=0; i<n-1; i++) {
            graph[wires[i][0]-1][wires[i][1]-1] = 1;
            graph[wires[i][1]-1][wires[i][0]-1] = 1;
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j] == 1) {
                    graph[i][j] = 0;
                    graph[j][i] = 0;
                    tops = new int[2];
                    count(n, graph);
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }
        return answer;
    }
    static void count(int n, int[][] graph){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j] == 1) bfs(n, i, j);
                if(tops[1] != 0) {
                    answer = Math.min(answer, Math.abs(tops[0]-tops[1]));
                    return;
                }
            }
        }
    }
    static void bfs(int n, int curi, int curj){
        if(tops[0] != 0) {
            tops[1] = n - tops[0];
            return;
        }
        int count = 0;
        boolean[] visit = new boolean[n];
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(curj);
        visit[curj] = true;
        count++;
        
        while(!q.isEmpty()){
            int next = q.pop();
            for(int i=0; i<n; i++){
                if(!visit[i] && graph[next][i] == 1){
                    q.add(i);
                    visit[i] = true;
                    count++;
                }
            }
        }
        tops[0] = count;
    }
}