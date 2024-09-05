import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		HashMap<String, String> Listen=new HashMap<String, String>();
		for(int i=0; i<N; i++) {
			String line=br.readLine();
			Listen.put(line, line);
		}
		ArrayList<String> ListenSee=new ArrayList<>();
		for(int i=0; i<M; i++) {
			String line=br.readLine();
			if(Listen.containsKey(line)) ListenSee.add(line);
		}
		Collections.sort(ListenSee);
		System.out.println(ListenSee.size());
		for(String s: ListenSee) {
			System.out.println(s);
		}
	}
}