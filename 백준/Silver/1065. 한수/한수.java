import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[1001];
        int[] sum = new int[1001];

        for(int i=1; i<1001; i++){
            if(i<100) numbers[i] = 1;
            else if (i<1000){
                int first = i/100;
                int second = i%100 / 10;
                int third = i%10;

                if(first + third == second*2) numbers[i] = 1;
            }
        }
        for(int i=1; i<1001; i++) sum[i] = sum[i-1] + numbers[i];

        System.out.println(sum[N]);
        br.close();
    }
}