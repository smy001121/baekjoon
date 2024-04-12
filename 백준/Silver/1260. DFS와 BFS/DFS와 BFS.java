import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, V;
    static int[][] graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        visit = new boolean[N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(V);
        System.out.println();
        visit = new boolean[N+1];
        bfs(V);
    }

    static void dfs(int v) {
        visit[v] = true;
        System.out.print(v + " ");

        for(int i = 1; i <= N; i++) {
            if(!visit[i] && graph[v][i] == 1) {
                dfs(i);
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visit[v] = true;


        while(!q.isEmpty()) {
            int val = q.poll();
            System.out.print(val + " ");

            for(int i = 1; i <= N; i++) {
                if(!visit[i] && graph[val][i] == 1) {
                    q.add(i);
                    visit[i] = true;
                }
            }

        }
    }


}
