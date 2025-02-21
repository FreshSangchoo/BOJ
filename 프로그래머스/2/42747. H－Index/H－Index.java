import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int answer = binarySearch(citations);
        
        return answer;
    }
    static int binarySearch(int[] arr){
        int left = 0;
        int right = 10000;
        
        while(left + 1 < right){
            int mid = (left + right) / 2;
            
            if(mid > count(mid, arr)) right = mid;
            else left = mid;
        }
        return left;
    }
    static int count(int k, int[] arr){
        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] < k) continue;
            else {
                cnt = arr.length - i;
                break;
            }
        }
        return cnt;
    }
}