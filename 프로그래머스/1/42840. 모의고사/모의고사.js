function solution(answers) {
    var answer = [];
    const first = [1,2,3,4,5];
    const second = [2,1,2,3,2,4,2,5];
    const third = [3,3,1,1,2,2,4,4,5,5];
    
    let firstC = 0;
    let secondC = 0;
    let thirdC = 0;
    
    for(let i = 0; i < answers.length; i++){
        if(first[i%5] == answers[i]) firstC++;
        if(second[i%8]==answers[i]) secondC++;
        if(third[i%10]==answers[i]) thirdC++;
    }
    
    let highest = Math.max(firstC, secondC, thirdC);
    
    
    console.log(firstC);
    console.log(secondC);
    console.log(thirdC);
    
    if(firstC == highest) answer.push(1);
    if(secondC == highest) answer.push(2);
    if(thirdC == highest) answer.push(3);
    
    return answer;
}