import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(numbers);
        int count = 0;
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N-1;
            while(true){
                if(left == i) left++;
                if(right == i) right--;

                if(left >= right) break;

                if(numbers[left] + numbers[right] > numbers[i]) right--;
                else if(numbers[left]+numbers[right] < numbers[i]) left++;
                else {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}