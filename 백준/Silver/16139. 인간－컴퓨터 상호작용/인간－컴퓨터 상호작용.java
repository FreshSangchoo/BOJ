import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;

        int[] alphabet = new int[26];

        String str = br.readLine();
        int[][] sum = new int[str.length()+1][26];
        for(int i=1; i<=str.length(); i++){
            int curAlphabet = str.charAt(i-1) - 'a';
            alphabet[curAlphabet]++;
            for(int j=0; j<26; j++) sum[i][j]=alphabet[j];
        }

        int q=Integer.parseInt(br.readLine());
        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int findAlphabet = st.nextToken().charAt(0)-'a';
            int start=Integer.parseInt(st.nextToken())+1;
            int end=Integer.parseInt(st.nextToken())+1;

            int ans=sum[end][findAlphabet]-sum[start-1][findAlphabet];
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}