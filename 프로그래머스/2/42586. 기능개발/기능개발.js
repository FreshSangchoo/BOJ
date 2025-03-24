function solution(progresses, speeds) {
    var answer = [];
    
    let n = progresses.length;
    
    let arr = [];
    let day = 0;
    let dayCount = 0;
    
    while(progresses[0]){
        if(progresses[0] >= 100) {
            dayCount++;
            // console.log("작업 끝! "+progresses[0])
            progresses.shift();
            speeds.shift();
        } else {
            // console.log(dayCount+"개 작업했어");
            answer.push(dayCount);
            dayCount = 0;
            day = Math.ceil((100-progresses[0]) / speeds[0]);
            // console.log(day+"일 더 작업해야해");
            for(let i=0; i<progresses.length; i++){
                progresses[i] += speeds[i] * day;
            }
        }
    }
    answer.push(dayCount);
    answer.splice(0, 1)
    
    return answer;
}