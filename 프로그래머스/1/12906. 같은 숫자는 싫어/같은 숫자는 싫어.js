function solution(arr)
{
    var answer = [];

    let cur = -1;
    let n = arr.length;
    
    for(let i=0; i<n; i++){
        num = arr[i];
        if(cur !== num) answer.push(num);
        cur = num;
    }    
    
    return answer;
}