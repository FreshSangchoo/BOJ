import java.io.*;
import java.util.*;

public class Main {
    static int[] dwarf = new int[7];
    static int[] nineDwarf;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nineDwarf = new int[9];
        for(int i=0; i<9; i++) nineDwarf[i] = Integer.parseInt(br.readLine());

        dfs(0, 0);

        br.close();
    }
    static void dfs(int cnt, int cur){
        if(cnt == 7){
            int sum=0;
            for(int i=0; i<7; i++) sum+=dwarf[i];
            if(sum == 100){
                Arrays.sort(dwarf);
                for(int i=0; i<7; i++) System.out.println(dwarf[i]);
                System.exit(0);
            } else return;
        }
        for(int i=cur; i<9; i++){
            dwarf[cnt] = nineDwarf[i];
            dfs(cnt+1, i+1);
        }
    }
}