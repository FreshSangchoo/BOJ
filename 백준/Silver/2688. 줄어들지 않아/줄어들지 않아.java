import java.util.*;
import java.io.*;

public class Main {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        long[][] memo = new long[65][11];
        // int[] memoS = new int[10];
        // int[] memoSS = new int[10];
        // int[] memoSSS = new int[10];

        // for(int i=1; i<=10; i++){
        //     for(int j=1; j<=i; j++){
        //         memoS[i-1] += j;
        //     }
        // }
        // for(int i=0; i<10; i++){
        //     for(int j=0; j<=i; j++){
        //         memoSS[i] += memoS[j];
        //     }
        // }
        // for(int i=0; i<10; i++){
        //     for(int j=0; j<=i; j++){
        //         memoSSS[i] += memoSS[j];
        //     }
        // }

        // System.out.println("memoS: "+Arrays.toString(memoS));
        // System.out.println("memoSS: "+Arrays.toString(memoSS));
        // System.out.println("memoSSS: "+Arrays.toString(memoSSS));
        for(int i=1; i<=10; i++){
            memo[0][i] = i;
        }
        memo[1][0] = memo[0][10];
        
        for(int t=0; t<T; t++){
            n = Integer.parseInt(br.readLine());
            if(memo[n][0] != 0) {
                System.out.println(memo[n][0]);
                continue;
            }
            
            for(int i=1; i<n; i++){
                if(memo[i][10] != 0) continue;
                for(int j=1; j<=10; j++){
                    for(int k=1; k<=j; k++){
                        memo[i][j] += memo[i-1][k];
                    }
                }
                memo[i+1][0] = memo[i][10];
            }
                       
            // System.out.println(Arrays.toString(memo[n-1]));
            System.out.println(memo[n][0]);
        }
    }
}
