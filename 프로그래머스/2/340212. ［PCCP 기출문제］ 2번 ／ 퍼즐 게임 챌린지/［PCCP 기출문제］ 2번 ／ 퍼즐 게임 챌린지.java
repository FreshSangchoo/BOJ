class Solution {
    int maxDiff=0;
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        for(int i=0; i<diffs.length; i++){
            maxDiff = Math.max(diffs[i], maxDiff);
        }
        
        int first = binarySearch(diffs, times, limit);
        if(cal(diffs, times, first) <= limit) answer = first;
        else answer = first+1;
        
        return answer;
    }
    public long cal(int[] diffs, int[] times, int level){
        long time = 0;
        
        for(int i=0; i<diffs.length; i++){
            if(diffs[i] <= level){
                time += times[i];
            } else {
                int time_prev = times[i-1];
                int time_cur = times[i];
                
                time += (time_prev + time_cur) * (diffs[i] - level) + time_cur;
            }
        }
        
        return time;
    }
    public int binarySearch(int[] diffs, int[] times, long limit){
        int left = 1;
        int right = maxDiff;
        
        while(left + 1 < right){
            int mid = (left+right)/2;
            
            if(cal(diffs, times, mid) < limit) {
                right = mid;
            }
            else if(cal(diffs, times, mid) == limit) return mid;
            else {
                left = mid;
            }
        }
        
        return left;
    }
}