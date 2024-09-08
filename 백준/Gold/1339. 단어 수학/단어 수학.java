import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] alphabet = new int[26];

        for (int i = 0; i < N; i++) {
            String line=br.readLine();
            for(int j=line.length()-1; j>=0; j--) alphabet[line.charAt(line.length()-1-j)-'A']+=Math.pow(10, j);
        }
        int answer=0;
        int num=9;
        PriorityQueue<Integer> pq=new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for(int i=0; i<26; i++) if(alphabet[i]!=0) pq.offer(alphabet[i]);
        while(!pq.isEmpty()) answer+=pq.poll()*(num--);
        System.out.println(answer);
        br.close();
    }
}