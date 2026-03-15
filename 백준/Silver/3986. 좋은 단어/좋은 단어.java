import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;

        for(int t=0; t<N; t++){
            String str = br.readLine();

            ArrayDeque<Character> stack = new ArrayDeque<>();

            for(int i=0; i<str.length(); i++){
                if(stack.size() != 0){
                    char curStack = stack.peekLast();
                    char curChar = str.charAt(i);
    
                    if(curChar == curStack){
                        stack.pollLast();
                    } else {
                        stack.offer(curChar);
                    }
                } else {
                    stack.offer(str.charAt(i));
                }
            }

            if(stack.size() == 0){
                count++;
            }
        }

        System.out.println(count);
    }
}
