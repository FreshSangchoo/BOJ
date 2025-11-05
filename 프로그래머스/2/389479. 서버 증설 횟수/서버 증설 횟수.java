class Solution {
    public int solution(int[] players, int m, int k) {
        int[] server = new int[24];
        int answer = 0;
        
        for(int i=0; i<24; i++){
            if(players[i] >= (server[i] + 1) * m) {
                while(players[i] >= (server[i]+1)*m){
                    answer++;
                    for(int time = 0; time < k; time++){
                        if(i+time >= 24) continue;
                        server[i+time]++;
                    }    
                }
                
            }
        }
        
        return answer;
    }
}