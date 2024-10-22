import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum=0;
        for(int i=0; i<10; i++){
            int num=Integer.parseInt(br.readLine());
            if(Math.abs(100-sum) >= Math.abs(100-sum-num)) sum+=num;
            else break;
        }
        System.out.println(sum);
        br.close();
    }
}