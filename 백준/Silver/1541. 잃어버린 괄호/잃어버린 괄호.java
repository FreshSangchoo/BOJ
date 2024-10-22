import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine(), "-");
		int ans=0;
		int first=-1;
		while(st.hasMoreTokens()) {
			int temp=0;
			StringTokenizer st2=new StringTokenizer(st.nextToken(), "+");
			while(st2.hasMoreTokens()) {
				temp+=Integer.parseInt(st2.nextToken());
			}
			if(first==-1) first=temp;
			else ans-=temp;
		}
		System.out.println(first+ans);
	}
}