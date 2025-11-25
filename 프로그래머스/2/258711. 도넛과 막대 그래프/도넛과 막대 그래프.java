import java.util.*;

class Solution {
    int[][] count;
    int maxNode = 0;
    public int[] solution(int[][] edges) {
        // 생성, 도넛, 막대, 8자
        int[] answer = new int[4];
        
        for(int i=0; i<edges.length; i++){
            maxNode = Math.max(edges[i][0], maxNode);
            maxNode = Math.max(edges[i][1], maxNode);
        }
        
        count = new int[maxNode+1][2];
        
        for(int i=0; i<edges.length; i++){
            int start = edges[i][0];
            int end = edges[i][1];
            
            // 노드별 출입 횟수    
            count[start][0]++;
            count[end][1]++;
        }
        
        int countGraph = 0;
        for(int i=0; i<maxNode+1; i++) {
            // 생성한 노드
            if(count[i][0] >= 2 && count[i][1] == 0) {
                answer[0] = i;
                countGraph = count[i][0];
            };
            
            // 8자 그래프 가운데 지점
            if(count[i][0] == 2 && count[i][1] >= 2){
                answer[3]++;
                continue;
            }
            
            // 막대 그래프
            if(count[i][0] == 0 && count[i][1] >=1){
                answer[2]++;
            }
        }
        
        answer[1] = countGraph - answer[2] - answer[3]; 
        
        return answer;
    }
}