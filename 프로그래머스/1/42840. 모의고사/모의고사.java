class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] correct = new int[3];
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == person1[i%5]) correct[0]++;
            if(answers[i] == person2[i%8]) correct[1]++;
            if(answers[i] == person3[i%10]) correct[2]++;
        }
        
        int maxScore = 0;
        for(int i=0 ; i<3; i++) maxScore = Math.max(maxScore, correct[i]);
        int count = 0;
        for(int i=0 ; i<3; i++) if(maxScore == correct[i]) count++;
        int[] best = new int[count];
        int tmp = 0;
        for(int i=0; i<3; i++) {
            if(maxScore == correct[i]){
                best[tmp] = i+1;
                tmp++;
            }
        };
        
        return best;
    }
}