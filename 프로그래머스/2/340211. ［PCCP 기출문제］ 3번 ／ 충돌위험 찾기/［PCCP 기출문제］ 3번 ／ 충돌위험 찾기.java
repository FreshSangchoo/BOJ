import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int[][][] factory;
        int maxR = 0;
        int maxC = 0;
        int answer = 0;
        
        for(int i=0; i<points.length; i++){
            maxR = Math.max(maxR, points[i][0]);
            maxC = Math.max(maxC, points[i][1]);
        }
        
        int maxTime = 0;
        
        for(int i=0; i<routes.length; i++){
            int[] route = routes[i];
            int time = 0;
            
            for(int j=0; j<route.length - 1; j++){
                int start = route[j];
                int end = route[j+1];
                
                int startR = points[start-1][0];
                int startC = points[start-1][1];
                int endR = points[end-1][0];
                int endC = points[end-1][1];
                
                time += Math.abs(startR - endR) + Math.abs(startC - endC);
            }
            
            maxTime = Math.max(maxTime, time);
        }
        
        factory = new int[maxR+1][maxC+1][maxTime+1];
        
        // 로봇 움직이기
        for(int i=0; i<routes.length; i++){
            int[] route = routes[i];
            
            int startPoint = route[0];
            int currentR = points[startPoint-1][0];
            int currentC = points[startPoint-1][1];
            int t = 0;
            
            if(++factory[currentR][currentC][t] == 2) answer++;
            
            for(int j=1; j<route.length; j++){
                int nextPoint = route[j];
                int nextR = points[nextPoint-1][0];
                int nextC = points[nextPoint-1][1];
                
                while(currentR != nextR || currentC != nextC){
                    if(currentR != nextR){
                        if(currentR < nextR) currentR++;
                        else currentR--;
                    } else if(currentC != nextC) {
                        if(currentC < nextC) currentC++;
                        else currentC--;
                    }
                    
                    t++;
                    
                    if(++factory[currentR][currentC][t] == 2) answer++;
                }
            }
        }
        
        return answer;
    }
}