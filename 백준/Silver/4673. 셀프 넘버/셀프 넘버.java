import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder();
        boolean[] selfNumbers = new boolean[10001];
        for(int i=0;i<selfNumbers.length;i++) selfNumbers[i]=true;

        for(int i=1; i<10001; i++){
            int sum = i;
            while(sum<10000){
                int num = sum;
                while (num > 0) {
                    sum+=num%10;
                    num/=10;
                }
                if(sum > 10000) break;
                selfNumbers[sum] = false;
            }
        }
        for(int i=1; i<10001; i++) if(selfNumbers[i]) sb.append(i).append("\n");
        System.out.println(sb);
    }
}