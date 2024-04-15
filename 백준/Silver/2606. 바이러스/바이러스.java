import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static boolean[] visited;
	static int cnt;
	static ArrayList<Integer>[] connected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int com = sc.nextInt(); // 컴퓨터의 수
		int connect = sc.nextInt(); // 연결된 컴퓨터 쌍의 수
		
		
		visited = new boolean[com+1];
		connected = new ArrayList[com+1]; // 각 컴퓨터에 연결된 컴퓨터들 정보
		
		for(int i = 1; i <= com; i++) {
			connected[i] = new ArrayList<Integer>();
		}

		for(int i = 0; i < connect; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			connected[a].add(b);
			connected[b].add(a);
		}
		
		cnt = 0;
		
		bfs(1);
		
		System.out.println(cnt);
		
	}
	
	
	static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(n);
		visited[n] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i : connected[now]) {
				if(visited[i] == false) {
					cnt++;
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}

}
