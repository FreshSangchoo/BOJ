import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        int N = numbers.length;
        String ans = "";
        String[] nums = new String[N];
        
        for(int i=0; i<N; i++) nums[i] = String.valueOf(numbers[i]);
        
        Arrays.sort(nums, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        
        for(int i=0; i<N; i++) ans+=nums[i];
        
        if(ans.charAt(0) == '0') ans = "0";
        
        return ans;
    }
}