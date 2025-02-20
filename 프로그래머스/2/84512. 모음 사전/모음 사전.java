import java.util.*;

class Solution {
    static int number = 0;
    static String[] str = {"A", "E", "I", "O", "U"};
    static HashMap<String, Integer> dict = new HashMap<>();
    public int solution(String word) {
        int answer = 0;
        
        makeDict("", 0);
        
        return dict.get(word);
    }
    static void makeDict(String nextWord, int length){
        dict.put(nextWord, number++);
        if(length == 5) return;
        for(int i=0; i<5; i++){
            makeDict(nextWord+str[i], length+1);
        }
    }
}