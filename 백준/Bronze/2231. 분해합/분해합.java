import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer>[] numbers = new ArrayList[1000001];
        for(int i=0; i<1000001; i++) numbers[i] = new ArrayList<>();
        for (int i = 1; i < 1000001; i++) {
            int num = i;
            int sum = num;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            if(sum <= 1000000) numbers[sum].add(i);
        }
//        for(int i=1; i<1000001; i++) System.out.println(numbers[i].get(0));
        if(numbers[N].size() == 0) System.out.println(0);
        else System.out.println(numbers[N].get(0));
    }
}