import java.util.*;

class Solution {
    int INF = 1000000000;
    int lengInfo = 0;
    int minSumA = 0;
    int maxA = 0;
    int maxB = 0;
    int[][] bestA;
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        lengInfo = info.length;
        minSumA = n+1;
        maxA = n;
        maxB = m;
        bestA = new int[lengInfo + 1][m];
        for(int i=0; i<=lengInfo; i++) Arrays.fill(bestA[i], INF);
        
        int minTake = 0;
        for(int i=0; i<lengInfo; i++){
            minTake += Math.min(info[i][0], info[i][1]);
        }
        
        thief(0, info, 0, 0);
               
        if(minSumA >= n) minSumA = -1;
        
        return minSumA;
    }
    
    public void thief(int count, int[][] info, int sumA, int sumB){
        
        if(sumA >= minSumA) return;
        if(sumA >= maxA) return;
        if(sumB >= maxB) return;
        if(sumA >= bestA[count][sumB]) return;
        bestA[count][sumB] = sumA;
        if(count == lengInfo){
            minSumA = Math.min(minSumA, sumA);
            return;
        }
        thief(count+1, info, sumA, sumB+info[count][1]);
        thief(count+1, info, sumA+info[count][0], sumB);
        
    }
}