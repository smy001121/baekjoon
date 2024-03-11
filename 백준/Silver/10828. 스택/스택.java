import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		
		Stack<Integer> st = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			String s = sc.next();
			
			if(s.contains("push")) {
				st.push(sc.nextInt());
			}
			if(s.contains("pop")) {
				if(st.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(st.pop()).append("\n");
				}
			}
			if(s.contains("size")) {
				sb.append(st.size()).append("\n");
			}
			if(s.contains("empty")) {
				if(st.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			}
			if(s.contains("top")) {
				if(st.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(st.peek()).append("\n");
				}
			}
			
			
			
			
		}
		
		System.out.println(sb);
		
		
		
			
	}

}