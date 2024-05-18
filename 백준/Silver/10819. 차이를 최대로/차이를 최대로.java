import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visit;
    static int[] result;
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[N];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr, 0);
        System.out.println(max);
    }

    static void dfs(int[] arr, int depth) {
        if(depth == N) {
            int sum = 0;
            for(int i = 0; i < N-1; i++) {
                sum += Math.abs(result[i] - result[i+1]);
            }
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visit[i]) {
                result[depth] = arr[i];
                visit[i] = true;
                dfs(arr, depth+1);
                visit[i] = false;
            }
        }
    }
}
