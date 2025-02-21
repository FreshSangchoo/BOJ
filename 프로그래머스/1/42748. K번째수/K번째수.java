import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int T = commands.length;
        int[] answer = new int[T];
                
        for(int t=0; t<T; t++){
            int start = commands[t][0];
            int end = commands[t][1];
            int[] cutArr = new int[end-start+1];
            int index = 0;
            
            for(int i=start-1; i<end; i++) cutArr[index++] = array[i];
            
            Arrays.sort(cutArr);
            answer[t] = cutArr[commands[t][2]-1];
        }
        
        return answer;
    }
}