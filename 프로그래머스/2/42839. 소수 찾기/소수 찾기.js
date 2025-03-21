function solution(numbers) {
    const answer = [];
    
    let nums = numbers.split("");
    
    const isPrime = (num) => {
        if(num<=1) return false;
        for(let i=2; i*i<=num; i++){
            if(num % i === 0) return false;
        }
        return true;
    }
    
    const permutation = (arr, fixed) => {
        if(arr.length >= 1){
            for(let i=0; i<arr.length; i++){
                const newNum = fixed + arr[i];
                const newArr = [...arr];
                newArr.splice(i, 1);
                if(!answer.includes(+newNum) && isPrime(+newNum)) answer.push(+newNum);
                permutation(newArr, newNum);
            }
        }
    }
    permutation(nums, '');

    return answer.length;
}