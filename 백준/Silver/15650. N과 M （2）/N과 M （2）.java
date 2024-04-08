import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visit = new boolean[N];

        dfs(N, M, 0);
        System.out.print(sb);
    }

    static void dfs(int N, int M, int depth) {
        if(depth == M) {
            for(int val : arr) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(depth <= 0) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth+1);

                visit[i] = false;
            } else if(arr[depth-1] < i + 1) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth+1);

                visit[i] = false;
            }
        }
    }
}
