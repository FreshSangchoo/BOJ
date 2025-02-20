class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int width = 0;
        int height = 0;
        int total = brown + yellow;
        
        height = (brown+4)/4;
        width = (brown+4) / 2 - height;
        
        while(true) {
            if(total == width * height) {
                answer[0] = width;
                answer[1] = height;
                break;
            }
            width++;
            height--;
        }
        
        return answer;
    }
}