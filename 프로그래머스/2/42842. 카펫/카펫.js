function solution(brown, yellow) {
    var answer = [];
    
    let width = 0;
    let height = 0;
    let total = brown + yellow;
    
    height = Math.floor((brown+4)/4);
    width = (brown+4)/2 - height;

    while(true){
        
        if(total === width * height){
            answer[0] = width;
            answer[1] = height;
            break;
        }
        width++;
        height--;
    }
    
    return answer;
}