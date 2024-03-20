import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] visited;
	static List<Integer>[] list;
	static int[] result;
	static int count = 0;
	static int N, M, R;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점
		M = Integer.parseInt(st.nextToken()); // 간선
		R = Integer.parseInt(st.nextToken()); // 시작 정점
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		result = new int[N+1];
		
		for(int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i = 1; i < N+1; i++) {
			Collections.sort(list[i], Collections.reverseOrder());
		}
		
		bfs(R);

	}
	
	public static void bfs(int r) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(r);
		visited[r] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			count++;
			result[now] = count;
			
			for(int next : list[now]) {
				if(!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
		
		for(int i = 1; i < N+1; i++) System.out.println(result[i]);
		
	}

}
